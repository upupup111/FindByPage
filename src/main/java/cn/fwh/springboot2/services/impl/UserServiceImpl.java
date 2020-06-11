package cn.fwh.springboot2.services.impl;

import cn.fwh.springboot2.dao.UserDao;
import cn.fwh.springboot2.entiy.User;
import cn.fwh.springboot2.services.UserServices;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findall() {
        //null表示查询条件为无条件
        return userDao.selectList(null);
    }

    //page表示当前页码，size表示每页的数据条数
    @Override
    public Page<User> getUserList(Integer page, Integer size) {
        //构建一个分页条件
        Page<User> pageParm = new Page<User>();
        //设置当前页面
        pageParm.setCurrent(page);
        //设置页面大小
        pageParm.setSize(size);
        // 设置排序规则
        pageParm.addOrder(OrderItem.desc("id"));
        //调用mybatisPlus的分页函数，再将pageParm传入到oageParm中
        pageParm = userDao.selectPage(pageParm,null);
        return pageParm;
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        // mybatisplus会判断不为null的字段，如果不为null则例如更新的字段
        return userDao.updateById(user);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }
}
