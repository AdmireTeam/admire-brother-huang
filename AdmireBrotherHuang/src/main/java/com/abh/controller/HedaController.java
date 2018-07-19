package com.abh.controller;

import com.abh.constants.RequestConst;
import com.abh.model.HedaRequestDTO;
import com.abh.provider.client.HdClient;
import com.abh.utils.R;
import com.abh.utils.ThymeleafUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/heda")
public class HedaController {

    private static Logger logger = LogManager.getLogger(HedaController.class);


	@GetMapping()
	public String homePage(Model model){
        HedaRequestDTO hedaRequestDTO = new HedaRequestDTO();
        hedaRequestDTO.setNumber(RequestConst.HedaNumber);
        hedaRequestDTO.setK4(RequestConst.HedaK4);
        hedaRequestDTO.setK5(RequestConst.HedaK5);
        hedaRequestDTO.setA1(RequestConst.HedaA1);
        hedaRequestDTO.setA2(RequestConst.HedaA2);
        hedaRequestDTO.setA3(RequestConst.HedaA3);
        hedaRequestDTO.setA12(RequestConst.HedaA12);
        hedaRequestDTO.setA13(RequestConst.HedaA13);
        hedaRequestDTO.setP13(RequestConst.HedaP13);
        hedaRequestDTO.setP14(RequestConst.HedaP14);


        model.addAttribute("InputItemDTOS", ThymeleafUtils.model2List(hedaRequestDTO, HedaRequestDTO.class));
		return "home/heda";
	}



    @ResponseBody
    @RequestMapping("/send")
    public R update(HedaRequestDTO hedaRequestDTO){
        logger.debug("send request:" + ThymeleafUtils.modelDumps(hedaRequestDTO, HedaRequestDTO.class));
        HdClient.send(hedaRequestDTO);
        return R.ok();
    }

}
