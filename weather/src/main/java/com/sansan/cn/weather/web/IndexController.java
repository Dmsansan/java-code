package com.sansan.cn.weather.web;

import com.alibaba.fastjson.JSON;
import com.sansan.cn.weather.utils.HttpRequestUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    /**
     * 首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        mv.addObject("name", "weather home");
        mv.setViewName("city-weather");
        return mv;
    }

    /**
     * 根据城市代码获取当前城市温度
     * @param cityCode
     * @return
     */
    @RequestMapping(value = "/queryCityWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String queryCityWeather(@RequestParam(value = "cityCode") String cityCode){
        String url = "http://t.weather.sojson.com/api/weather/city/" + cityCode;
        String weatherRes = HttpRequestUtil.sendGet(url);

        return weatherRes;
    }
}
