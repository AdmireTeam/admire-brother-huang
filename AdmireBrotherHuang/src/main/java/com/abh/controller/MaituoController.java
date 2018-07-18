package com.abh.controller;
import com.abh.constants.RequestConst;
import com.abh.model.MaituoRequestDTO;
import com.abh.provider.client.MtClient;
import com.abh.provider.message.MaituoMessage;
import com.abh.utils.R;
import com.abh.utils.ThymeleafUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/maituo")
public class MaituoController {

    private static Logger logger = LogManager.getLogger(MaituoController.class);


    @GetMapping()
    public String homePage(Model model){
        MaituoRequestDTO maituoRequestDTO = new MaituoRequestDTO();
        maituoRequestDTO.setNumber(RequestConst.MtConAddress);
        maituoRequestDTO.setWaterNum(RequestConst.MtWaterNum);
        maituoRequestDTO.setAccu1(RequestConst.MtAccumulate1);
        maituoRequestDTO.setAccu2(RequestConst.MtAccumulate2);
        maituoRequestDTO.setInstant(RequestConst.MtInstantFlow);
        maituoRequestDTO.setTime(RequestConst.MtTime);



        model.addAttribute("InputItemDTOS", ThymeleafUtils.model2List(maituoRequestDTO, MaituoRequestDTO.class));
        return "home/maituo";
    }



    @ResponseBody
    @RequestMapping("/send")
    public R update(MaituoRequestDTO maituoRequestDTO){
        logger.debug("send request:" + ThymeleafUtils.modelDumps(maituoRequestDTO, MaituoRequestDTO.class));
        try {
            MtClient.send(maituoRequestDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }


}
