package cn.fwh.springboot2.controller;

import cn.fwh.springboot2.entiy.User;
import cn.fwh.springboot2.services.UserServices;
import cn.fwh.springboot2.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
    @GetMapping("/findall")
    public Map<String,Object> findall(){
        Map<String,Object> maps = new HashMap<>();
        maps = ResponseUtil.success(userServices.findall());
        return maps;
    }
}
