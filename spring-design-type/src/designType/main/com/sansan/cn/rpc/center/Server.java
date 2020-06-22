package designType.main.com.sansan.cn.rpc.center;

import java.io.IOException;

public interface Server {
    public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}
