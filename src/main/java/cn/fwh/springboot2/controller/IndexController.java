package cn.fwh.springboot2.controller;

import cn.fwh.springboot2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private UserServices userServices;
    @GetMapping("findbypage")
    public String findbypage(){
        return "index";
    }
    @GetMapping("again")
    public String again(){
        return "again";
    }
}
