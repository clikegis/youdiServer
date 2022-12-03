package com.cy.youdi.controller;

import com.cy.youdi.result.Result;
import com.cy.youdi.service.YoudiService;
import com.cy.youdi.utils.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class YoudiController {
    @Autowired
    YoudiService youdiService;

    @RequestMapping("/getVec")
    Result getVec(@RequestParam("pl") Double pl,@RequestParam("pg") Double pg,@RequestParam("d") Double d,@RequestParam("g") Double g,@RequestParam("ug") Double ug){
        Velocity velocity = new Velocity(pl,pg,d,g,ug);
        return new Result(200,"success",velocity.getAllVec());
    }

    @RequestMapping("/getAllData")
    Result getAllData(){
        return new Result(200,"success",youdiService.getAllData());
    }
}
