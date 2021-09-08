package com.app.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppResult extends HashMap<String, Object> implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public AppResult()
    {
        put("code", 200);
    }
    
    public static AppResult error()
    {
        return commonResult(500, "服务异常");
    }
    
    public static AppResult error(String msg)
    {
        return commonResult(500, msg);
    }
    
    public static AppResult commonResult(int code, String msg)
    {
        AppResult r = new AppResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    
    public static AppResult commonResult(int code, String msg, Object data)
    {
        AppResult r = new AppResult();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }
    
    public static AppResult ok()
    {
        AppResult r = new AppResult();
        r.put("msg", "请求成功");
        return r;
    }
    
    public static AppResult ok(String msg)
    {
        AppResult r = new AppResult();
        r.put("msg", msg);
        return r;
    }
    
    public static AppResult ok(Map<String, Object> map)
    {
        AppResult r = new AppResult();
        r.put("msg", "请求成功");
        r.putAll(map);
        return r;
    }
    
    public AppResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
    
}