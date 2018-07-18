package com.abh.provider.client;


import com.abh.constants.RequestConst;
import com.abh.model.HedaRequestDTO;
import com.abh.provider.message.HedaMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class HdClient extends BaseClient{

    private static Logger logger = LogManager.getLogger(HdClient.class);

    public static void send(HedaRequestDTO hedaRequestDTO){
        String requestMessage = HedaMessage.generateMessage(hedaRequestDTO);
        logger.debug("heda request:" + requestMessage);
        String[] requestMessages = new String[1];
        try {
            sendMessage(RequestConst.HedaHost, RequestConst.HedaPort, requestMessages);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
