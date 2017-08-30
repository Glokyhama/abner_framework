package com.abner.controller;


import com.abner.service.core.CoreService;
import com.abner.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@Controller
public class ApiController {

    @Autowired
    private CoreService coreService;

    @RequestMapping("/signup")
    @ResponseBody
    public Object signup(String name, String email, String password) {
        System.out.println("name:" + name);
        System.out.println("email:" + email);
        System.out.println("password:" + password);

        String time = DateUtil.getCurrentDate();

        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "success");
        map.put("time", time);

        Map<String, String> respMap = new HashMap<>();

        respMap.put("name", name);
        respMap.put("email", email);
        respMap.put("password", password);


        map.put("resp", respMap.toString());
        return map;

    }
}
