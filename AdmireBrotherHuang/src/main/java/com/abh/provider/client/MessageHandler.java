package com.abh.provider.client;


import com.abh.utils.ConvertUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public  class MessageHandler extends ChannelInboundHandlerAdapter{

	   @Override
	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception  { 
	    	
	    	ByteBuf result = (ByteBuf) msg;  
	        byte[] result1 = new byte[result.readableBytes()];  
	        result.readBytes(result1);  
	        //String resultStr = new String(result1);
	        String resultStr = ConvertUtil.bytesToHexFun2(result1);
	        System.out.println("客户端接受的消息: " + resultStr);       
	    }

		//
	    @Override
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("正在连接... ");  
	        super.channelActive(ctx);
	    
	    }
	   

	    @Override
	    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("连接关闭! ");
	        super.channelInactive(ctx);
	    }

}
