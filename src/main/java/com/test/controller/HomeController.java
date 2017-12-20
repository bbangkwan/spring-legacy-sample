package com.test.controller;

import com.test.config.AppInitialzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Bae B K on 2017. 12. 20.
 */

@Controller
public class HomeController {
    private Logger log = LoggerFactory.getLogger(AppInitialzer.class);
    
    @RequestMapping(value = "/")
    @ResponseBody
    public String home(){
        return "spring legacy sample with java config!!!";
    }
}
