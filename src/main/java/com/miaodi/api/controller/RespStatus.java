package com.miaodi.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Useradmin on 2016/8/5.
 */
@Controller
public class RespStatus {
    @RequestMapping("/smsResp")
    @ResponseBody
    public String home() {
        return "hello";
    }
}
