package com.abh.controller;
import com.abh.constants.RequestConst;
import com.abh.model.RolaRequestDTO;
import com.abh.provider.client.RolaClient;
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
@RequestMapping("/rola")
public class RolaController {

    private static Logger logger = LogManager.getLogger(MaituoController.class);


    @GetMapping()
    public String homePage(Model model){
        RolaRequestDTO rolaRequestDTO = new RolaRequestDTO();
        rolaRequestDTO.setConNum(RequestConst.RolaConAddress);
        rolaRequestDTO.setWaterNum(RequestConst.RolaWaterNum);
        rolaRequestDTO.setReading(RequestConst.RolaReading);

        model.addAttribute("InputItemDTOS", ThymeleafUtils.model2List(rolaRequestDTO, RolaRequestDTO.class));
        return "home/rola";
    }



    @ResponseBody
    @RequestMapping("/send")
    public R update(RolaRequestDTO rolaRequestDTO){
        logger.debug("send request:" + ThymeleafUtils.modelDumps(rolaRequestDTO, RolaRequestDTO.class));
        try {
            RolaClient.send(rolaRequestDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

}
