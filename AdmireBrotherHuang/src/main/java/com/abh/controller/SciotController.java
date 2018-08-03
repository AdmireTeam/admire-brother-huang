package com.abh.controller;

import com.abh.constants.RequestConst;
import com.abh.model.SciotRequestDTO;
import com.abh.provider.client.SciotClient;
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
@RequestMapping("/sciot")
public class SciotController {

    private static Logger logger = LogManager.getLogger(SciotController.class);


    @GetMapping()
    public String homePage(Model model){
        SciotRequestDTO sciotRequestDTO = new SciotRequestDTO();
        sciotRequestDTO.setWaterNum(RequestConst.SciotWaterNum);
        sciotRequestDTO.setReading(RequestConst.SciotReading);
        sciotRequestDTO.setStartDate(RequestConst.SciotStartDate);

        model.addAttribute("InputItemDTOS", ThymeleafUtils.model2List(sciotRequestDTO, SciotRequestDTO.class));
        return "home/sciot";
    }



    @ResponseBody
    @RequestMapping("/send")
    public R update(SciotRequestDTO sciotRequestDTO){
        logger.debug("send request:" + ThymeleafUtils.modelDumps(sciotRequestDTO, SciotRequestDTO.class));
        try {
            SciotClient.send(sciotRequestDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

}
