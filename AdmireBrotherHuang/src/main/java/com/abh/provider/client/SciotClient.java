package com.abh.provider.client;

import com.abh.constants.RequestConst;
import com.abh.model.SciotRequestDTO;
import com.abh.provider.message.SciotMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class SciotClient extends BaseClient{

    private static Logger logger = LogManager.getLogger(SciotClient.class);

    public static void send(SciotRequestDTO sciotRequestDTO) throws IOException {
        String requestMessage = SciotMessage.generateMessage(sciotRequestDTO);

        logger.debug("sciot request:" + requestMessage);
        String[] requestMessages = new String[1];
        requestMessages[0] = requestMessage;

        try {
            sendMessage(RequestConst.HedaHost, RequestConst.SciotPort, requestMessages);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


