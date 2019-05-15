package designType.main.com.sansan.cn.GateWay;

public abstract class GateWayHandler {

    /**
     * 执行下一个Handler
     */
    protected GateWayHandler nextGateWayHandler;

    public void setNextGateWayHandler(GateWayHandler nextGateWayHandler) {
        this.nextGateWayHandler = nextGateWayHandler;
    }

    public abstract void service();

    protected void nextService() {
        if (nextGateWayHandler != null)
            // 指向下一关
            nextGateWayHandler.service();
    }
}
