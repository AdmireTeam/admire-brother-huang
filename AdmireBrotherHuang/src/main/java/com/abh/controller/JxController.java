package com.abh.controller;


import com.abh.constants.RequestConst;
import com.abh.model.JxRequestDTO;
import com.abh.model.RolaRequestDTO;
import com.abh.provider.client.JxClient;
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
@RequestMapping("/jiexian")
public class JxController {
    private static Logger logger = LogManager.getLogger(JxController.class);


    @GetMapping()
    public String homePage(Model model){
        JxRequestDTO jxRequestDTO = new JxRequestDTO();
        jxRequestDTO.setConAddr(RequestConst.JxconAddr);
        jxRequestDTO.setConCount(RequestConst.JxconCount);
        jxRequestDTO.setReading(RequestConst.Jxreading);
        jxRequestDTO.setMeterCount(RequestConst.JxmeterCount);

        model.addAttribute("InputItemDTOS", ThymeleafUtils.model2List(jxRequestDTO, JxRequestDTO.class));
        return "home/jiexian";
    }



    @ResponseBody
    @RequestMapping("/send")
    public R update(JxRequestDTO jxRequestDTO){
        logger.debug("send request:" + ThymeleafUtils.modelDumps(jxRequestDTO, JxRequestDTO.class));
        try {
            JxClient.send(jxRequestDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }
}
