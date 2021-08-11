package com.sansan.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * @author: sisansan
 * @vesion 1.0
 * @date: 2021-08-11 17:10
 * @description: websocket启动类
 **/
public class NioWebSocketServer {
    private final Logger logger = Logger.getLogger(this.getClass());

    private void init() {
        logger.info("正在启动websocket服务器");
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, work);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new NioWebSocketChannelInitializer());
            Channel channel = bootstrap.bind(8081).sync().channel();
            logger.info("webSocket服务器启动成功：" + channel);
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.info("运行出错：" + e);
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
            logger.info("websocket服务器已关闭");
        }
    }

    public static void main(String[] args) {
        new NioWebSocketServer().init();
    }
}
