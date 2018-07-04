package com.abh.controller;

import com.abh.model.SubmitDO;
import com.abh.model.TestDTO;
import com.abh.utils.R;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")
public class HomePageController {

    private static Logger logger = LogManager.getLogger(HomePageController.class);


    /**
     * 页面
     */
	@GetMapping()
	public String homePage(Model model){
        TestDTO testDTO = new TestDTO();
        testDTO.setFoo(123);
        testDTO.setBar("诶我?");
        model.addAttribute("testDTO", testDTO);
        model.addAttribute("eee", "额额");
		return "home/home";
	}


    /**
     * API
     */
    @ResponseBody
    @RequestMapping("/submit")
    public R update(SubmitDO submitDO){
        logger.debug("city id:" + submitDO.getCityId() + ", city name:" + submitDO.getName());
        return R.ok();
    }

}
