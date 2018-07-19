package com.abh.provider.client;
import com.abh.constants.RequestConst;
import com.abh.model.MaituoRequestDTO;
import com.abh.provider.message.MaituoMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class MtClient extends BaseClient{
    private static Logger logger = LogManager.getLogger(HdClient.class);

    public static void send(MaituoRequestDTO maituoRequestDTO) throws IOException {
        String requestMessage = MaituoMessage.generateHeartBytes(maituoRequestDTO);
        String upstreamMessage = MaituoMessage.generateUpStreamMessage(maituoRequestDTO);
        logger.debug("maituo request:" + requestMessage);
        String[] requestMessages = new String[2];
        requestMessages[0] = requestMessage;
        requestMessages[1] = upstreamMessage;
        try {
            sendMessage(RequestConst.HedaHost, RequestConst.HedaPort, requestMessages);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
