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

    @RequestMapping(value = "/login/{identifier}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@PathVariable(value = "identifier") String identifier, String identityType, String certificate) {

        return coreService.login(identifier, identityType, certificate);

    }
}
