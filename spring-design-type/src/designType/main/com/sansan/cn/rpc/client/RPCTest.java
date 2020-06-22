package designType.main.com.sansan.cn.rpc.client;

import designType.main.com.sansan.cn.rpc.center.Server;
import designType.main.com.sansan.cn.rpc.center.ServiceCenter;
import designType.main.com.sansan.cn.rpc.service.HelloService;
import designType.main.com.sansan.cn.rpc.service.HelloServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCTest {
    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHello("test"));
    }
}
