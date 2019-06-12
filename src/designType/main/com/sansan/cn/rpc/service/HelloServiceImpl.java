package designType.main.com.sansan.cn.rpc.service;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hi, " + name;
    }
}
