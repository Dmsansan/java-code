package Builder;

/**
 * 食品整体接口代码
 * 食品名称
 * 食品打包方式
 * 食品价格
 */
public interface Item {
    //食品名称
    public String name();
    //食品打包方式
    public Packing packge();
    //食品价格
    public float price();
}
