package cn.fwh.springboot2.entiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//使用Data注解不需要再写get和set方法
@Data
//定义所对应的数据库的表
@TableName("tables")
public class User {
    //@TableId代表表的主键,其中的type类型表示ID主键自增长
    @TableId(type = IdType.AUTO)
    private Integer id;
    //TableField注解表示映射的数据库列名
    @TableField("username")
    private String username;
    private String sex;
    //定义默认时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;
}
