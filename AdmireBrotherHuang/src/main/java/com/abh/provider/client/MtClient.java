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
        logger.debug("maituo request:" + requestMessage);
        try {
            sendMessage(RequestConst.HedaHost, RequestConst.HedaPort, requestMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
