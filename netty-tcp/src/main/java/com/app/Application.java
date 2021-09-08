package com.app;

import com.app.netty.NettyStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${tcpServer.enabled:false}")
    private boolean socketEnable;
    @Autowired
    private NettyStarter nettyStarter;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (socketEnable) {
            nettyStarter.clientStart();
        }
    }
}
