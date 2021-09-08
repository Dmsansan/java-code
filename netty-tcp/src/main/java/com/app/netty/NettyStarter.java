package com.app.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * netty客户端启停类
 */
@Slf4j
@Component
public class NettyStarter {

    @Value("${tcpServer.ip}")
    private String host;
    @Value("${tcpServer.port}")
    private int port;
    @Autowired
    private ClientHandler clientHandler;

    Bootstrap bootstrap = new Bootstrap();
    EventLoopGroup workGroup = new NioEventLoopGroup();

    public void clientStart() {
        clientStop();
        bootstrap = new Bootstrap();
        workGroup = new NioEventLoopGroup();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new IdleStateHandler(10, 10, 10));
                        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        socketChannel.pipeline().addLast(new ByteArrayDecoder());
                        socketChannel.pipeline().addLast(new LuckEncoder());
                        socketChannel.pipeline().addLast(clientHandler);
                    }
                });
        doConnect();
    }

    public void doConnect() {
        bootstrap.connect().addListener((ChannelFuture f) -> {
            if (!f.isSuccess()) {
                log.info("连接服务端失败，5s后重连...");
                final EventLoop loop = f.channel().eventLoop();
                loop.schedule(new Runnable() {
                    @Override
                    public void run() {
                        doConnect();
                    }
                }, 5L, TimeUnit.SECONDS);
            } else {
                log.info("建立连接，连接服务端成功！");
            }
        });
    }

    public boolean clientStop() {
        try {
            log.info("关闭连接！");
            workGroup.shutdownGracefully().sync();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}