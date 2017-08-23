package com.abner.controller;


import com.abner.service.core.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/core")
@Controller
public class CoreController {

    @Autowired
    private CoreService coreService;

    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String hello() {
        return "你好！hello";
    }

    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String say(@PathVariable(value = "msg") String msg) {
        return "{\"msg\":\"you say:'" + msg + "'\"}";
    }

    @RequestMapping("login")
    public String login(String identifier, String identityType, String certificate) {

        coreService.login(identifier, identityType, certificate);

        return "";
    }
}
