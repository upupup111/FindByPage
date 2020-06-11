package cn.fwh.springboot2.services;

import cn.fwh.springboot2.entiy.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface UserServices {
    //查询所有用户
    List<User> findall();
    //分页查询，返回Page<User>类型
    Page<User> getUserList(Integer page,Integer size);
    //删除，返回值为int类型
    int delete(Integer id);
    //修改，返回值为int类型
    int update(User user);
    //添加用户，返回值为int类型
    int insert(User user);
}
