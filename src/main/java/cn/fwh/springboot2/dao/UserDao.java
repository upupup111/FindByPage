package cn.fwh.springboot2.dao;

import cn.fwh.springboot2.entiy.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
//通过继承BaseMapper来实现CRUD功能
public interface UserDao extends BaseMapper<User> {
}
