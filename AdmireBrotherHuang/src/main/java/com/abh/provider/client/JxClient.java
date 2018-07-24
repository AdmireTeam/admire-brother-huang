package com.abh.provider.client;

import com.abh.constants.RequestConst;
import com.abh.model.JxRequestDTO;
import com.abh.provider.message.JxMessage;
import com.abh.provider.message.MaituoMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class JxClient extends BaseClient{
    private static Logger logger = LogManager.getLogger(HdClient.class);

    public static void send(JxRequestDTO jxRequestDTO) throws IOException {
        String requestMessage = JxMessage.generateMessage(1,jxRequestDTO);
        String upstreamMessage = JxMessage.generateMessage(2,jxRequestDTO);
        logger.debug("jiexian request:" + requestMessage);
        String[] requestMessages = new String[2];
        requestMessages[0] = requestMessage;
        requestMessages[1] = upstreamMessage;
        try {
            sendMessage(RequestConst.HedaHost, RequestConst.JxPort, requestMessages);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
