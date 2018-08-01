package com.abh.controller;


import com.abh.constants.RequestConst;
import com.abh.model.RolaRequestDTO;
import com.abh.model.XtRequestDTO;
import com.abh.provider.client.XtClient;
import com.abh.utils.R;
import com.abh.utils.ThymeleafUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/xintian")
public class XtController {
    private static Logger logger = LogManager.getLogger(MaituoController.class);


    @GetMapping()
    public String homePage(Model model){
        XtRequestDTO xtRequestDTO = new XtRequestDTO();
        xtRequestDTO.setConStartAddr(RequestConst.XtconAddr);
        xtRequestDTO.setConCount(RequestConst.XtconCount);
        xtRequestDTO.setMeterCount(RequestConst.XtmeterCount);
        xtRequestDTO.setMeterStartAddr(RequestConst.XtMeterStartAddr);
        xtRequestDTO.setReading(RequestConst.Xtreading);

        model.addAttribute("InputItemDTOS", ThymeleafUtils.model2List(xtRequestDTO, XtRequestDTO.class));
        return "home/xintian";
    }



    @ResponseBody
    @RequestMapping("/send")
    public R update(XtRequestDTO xtRequestDTO){
        logger.debug("send request:" + ThymeleafUtils.modelDumps(xtRequestDTO, XtRequestDTO.class));
        try {
            XtClient.send(xtRequestDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }
}
