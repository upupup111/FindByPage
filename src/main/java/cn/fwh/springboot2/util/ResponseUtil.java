package cn.fwh.springboot2.util;

import java.util.HashMap;
import java.util.Map;

public final class ResponseUtil {
    public static final Map<String,Object> success(Object data){
        Map<String,Object> maps = new HashMap<>();
        // 初始化返回信息的字段
        maps.put("code",0);
        maps.put("time",System.currentTimeMillis());
        maps.put("msg","success");
        maps.put("data",data);
        return maps;
    }

    public final static Map<String, Object> build(Integer code, String msg) {
        Map<String, Object> maps = new HashMap<>();
        //初始化返回的数据字段
        maps.put("code", code);
        maps.put("time", System.currentTimeMillis());
        maps.put("msg", msg);
        return maps;
    }

}
