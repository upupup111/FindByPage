package cn.fwh.springboot2.controller;

import cn.fwh.springboot2.entiy.User;
import cn.fwh.springboot2.services.UserServices;
import cn.fwh.springboot2.services.impl.UserServiceImpl;
import cn.fwh.springboot2.util.ResponseUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController3 {
    @Autowired
    private UserServiceImpl userServices;
    @GetMapping("/page")
    @ResponseBody
    //在Controller层中的当前页面必须是page，页面大小必须是limit
    public Map<String,Object> findbypage(Integer page, Integer limit){
        //获取当前页面的数据
        Page<User> users = userServices.getUserList(page,limit);
        //将users中的数据传入到maps中
        Map<String,Object> maps = ResponseUtil.success(users.getRecords());
        //users.getTotal()获取当前记录的总条数
        maps.put("count",users.getTotal());
        return maps;
    }
    @PostMapping("/user/delete")
    @ResponseBody
    public Map<String,Object> delete(Integer id){
        //调用服务器接口方法，进行删除
        int result = userServices.delete(id);
        return ResponseUtil.build(result > 0?0:501,result > 0?"删除成功":"删除失败，请联系管理员！");
    }
    @PostMapping("/user/update")
    @ResponseBody
    public Map<String,Object> update(User user){
        //调用服务器接口方法，进行修改
        int result = userServices.update(user);
        return ResponseUtil.build(result > 0?0:501,result > 0?"修改成功":"修改失败，请联系管理员！");
    }
    @ResponseBody
    @PostMapping("/user/insert")
    public Map<String,Object> insert(User user){
        int result = userServices.insert(user);
        return ResponseUtil.build(result > 0?0:501,result > 0?"添加成功":"添加失败，请联系管理员！");
    }
}
