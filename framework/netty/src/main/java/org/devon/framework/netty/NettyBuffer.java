package org.devon.framework.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyBuffer {


    public static void main(String[] args) {
        ByteBuf buf = Unpooled.buffer();
        ByteBuf directBuf = Unpooled.directBuffer();
        ByteBuf buf1 = Unpooled.compositeBuffer();


    }
}
