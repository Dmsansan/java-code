package com.itstyle.quartz.web;

import com.itstyle.quartz.entity.Result;
import com.itstyle.quartz.service.IJobService;
import com.itstyle.quartz.service.IUserService;
import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author siss
 * @date 2020/9/29  9:43
 */
@RestController
@RequestMapping(value = "sys")
public class SysController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SysController.class);

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IJobService iJobService;

    /**
     * 获取首页头部统计信息
     *
     * @return
     */
    @GetMapping(value = "/getHeadTabNumbers")
    public Result getHeadTabNumbers(){
        LOGGER.info("获取主页头部统计数据");
        Map<String, Object> resultMap = new HashMap<>(4);

        int user_numbers = iUserService.queryAllCount();
        resultMap.put("user_numbers", user_numbers);

        int job_numbers = iJobService.queryAllCount();
        resultMap.put("job_numbers", job_numbers);

        double cpuLoad = osmxb.getSystemCpuLoad();
        int percentCpuLoad = (int) (cpuLoad * 100);
        resultMap.put("cup_average", percentCpuLoad);

        return Result.ok(resultMap);
    }
}
