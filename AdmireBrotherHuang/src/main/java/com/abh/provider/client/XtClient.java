package com.abh.provider.client;

import com.abh.constants.RequestConst;
import com.abh.model.XtRequestDTO;
import com.abh.provider.message.XtMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class XtClient extends BaseClient {
    private static Logger logger = LogManager.getLogger(XtClient.class);

    public static void send(XtRequestDTO xtRequestDTO) throws IOException {
        String requestMessage = XtMessage.generateMessage(1,xtRequestDTO);
        String requestMessage1 = XtMessage.generateMessage(2,xtRequestDTO);

        logger.debug("xintian request:" + requestMessage);
        logger.debug("xintian request:" + requestMessage1);
        String[] requestMessages = new String[2];
        requestMessages[0] = requestMessage;
        requestMessages[1] = requestMessage1;

        try {
            sendMessage(RequestConst.HedaHost, RequestConst.XtPort, requestMessages);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
