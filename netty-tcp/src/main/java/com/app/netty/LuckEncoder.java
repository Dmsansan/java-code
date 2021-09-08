package com.app.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: Sansan.si
 * @vesion 1.0
 * @date: 2021-09-07 17:57
 * @description: 自定义发送编码
 **/
@ChannelHandler.Sharable
public class LuckEncoder extends MessageToByteEncoder<Byte> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Byte aByte, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(aByte);
    }
}
