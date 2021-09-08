package com.app.netty;

import io.netty.channel.*;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

@Slf4j
@ChannelHandler.Sharable
@Component
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    private NettyStarter nettyStarter;

    private Channel channel;

    public static final byte HEART_BEAT = (byte) 0xff;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("接收到消息:{}", msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("与服务端断开连接，即将重连...");
        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(new Runnable() {
            @Override
            public void run() {
                nettyStarter.doConnect();
            }
        }, 5L, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    /**
     * 空闲心跳机制
     */
//    @Override
//    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//        if (evt instanceof IdleStateEvent) {
//            IdleState state = ((IdleStateEvent) evt).state();
//            log.info("发送空闲心跳");
//            ctx.writeAndFlush(HEART_BEAT);
////            if (state == IdleState.WRITER_IDLE) {// 写空闲时发心跳
////                ctx.writeAndFlush(HEART_BEAT);
////            }
//        } else {
//            super.userEventTriggered(ctx, evt);
//        }
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
//        定时心跳机制
        this.channel = ctx.channel();
        ping(ctx.channel());
    }

    private void ping(Channel channel) {
        ScheduledFuture<?> future = channel.eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                if (channel.isActive()) {
                    log.info("发送定时心跳");
                    channel.writeAndFlush(HEART_BEAT);
                } else {
                    channel.closeFuture();
                    throw new RuntimeException();
                }
            }
        }, 1L, TimeUnit.SECONDS);
        future.addListener(new GenericFutureListener() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.isSuccess()) {
                    ping(channel);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("192.168.10.130", 4002);
        socket.connect(socketAddress, 10000);
        socket.setKeepAlive(true);
        //设置读取超时时间为2s
        socket.setSoTimeout(5000);
        OutputStream socketWriter = socket.getOutputStream();
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        socketWriter.write((byte) 0xff);
        socketWriter.flush();
        out.flush();

        byte[] simulationByte = new byte[32];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(simulationByte);
        for (int i = 0; i < simulationByte.length; i++) {
            System.out.println(simulationByte[i]);
        }
    }

}
