package com.app.controller;

import com.app.netty.NettyStarter;
import com.app.utils.AppResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/netty")
public class NettyController {
    @Autowired
    NettyStarter nettyStarter;

    /**
     * 启动socket客户端
     * @return
     */
    @GetMapping("/start")
    public AppResult start() {
        nettyStarter.clientStart();
        return AppResult.ok("指令下发成功");
    }

    /**
     * 关闭socket客户端
     * @return
     */
    @GetMapping("/stop")
    public AppResult stop() {
        nettyStarter.clientStop();
        return AppResult.ok("指令下发成功");
    }

}
