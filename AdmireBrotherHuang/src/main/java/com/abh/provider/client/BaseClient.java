package com.abh.provider.client;

import com.abh.provider.message.HedaMessage;
import com.abh.utils.HexDumper;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

/**
 * Created by zqc on 2018/7/17.
 */
public class BaseClient {


    /**
     * Netty创建全部都是实现自AbstractBootstrap。
     * 客户端的是Bootstrap，服务端的则是    ServerBootstrap。
     **/
    public static void sendMessage(String host, int port, String message) throws InterruptedException, IOException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        Channel ch;
        System.out.println("客户端成功启动...");
        b.group(group);
        b.channel(NioSocketChannel.class);
        b.handler(new JxClientFilter());

        // 连接服务端
        ch = b.connect(host, port).sync().channel();
        System.out.println("send......");
        System.out.println("********************");

        ch.writeAndFlush(message);
    }


}
