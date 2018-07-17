package com.abh.provider.client;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class SendDataMany extends ChannelOutboundHandlerAdapter
{
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {  
		/** 			
        String response = (String) msg; 
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());  
        encoded.writeBytes(new byte[] {104,101,0,101,0,104,(byte)201});
        ctx.write(encoded);
        System.out.println("(byte)201"+(byte)201); 
        ctx.flush();
	    **/
	    String response = (String) msg; 
	    ByteBuf encoded = ctx.alloc().buffer(4 * response.length()); 
        byte[] bytes = test(response);
        encoded.writeBytes(bytes);
        ctx.write(encoded);
        ctx.flush();
	}

	public static byte[] test(String s) {
		int len = s== null ? 0 : s.length() / 2;
		byte[] bs = new byte[len];
		for ( int i = 0; i < len; i ++ ) {
			String hex = s.substring(i*2, i*2+2);
			int num = Integer.parseInt(hex, 16);
			bs[i] = new Byte((byte)num);
		}
		return bs;
	}
}
