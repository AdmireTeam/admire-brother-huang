package com.abh.provider.client;

import com.abh.constants.RequestConst;
import com.abh.model.RolaRequestDTO;
import com.abh.provider.message.RolaMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class RolaClient extends BaseClient{
    private static Logger logger = LogManager.getLogger(HdClient.class);

    public static void send(RolaRequestDTO rolaRequestDTO) throws IOException {
        String requestMessage = RolaMessage.generateMessage(rolaRequestDTO);

        logger.debug("rola request:" + requestMessage);
        String[] requestMessages = new String[1];
        requestMessages[0] = requestMessage;

        try {
            sendMessage(RequestConst.HedaHost, RequestConst.RolaPort, requestMessages);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


