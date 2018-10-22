package designType.main.com.sansan.cn.Builder;

/**
 * 冷饮实现类
 */
public abstract class CouldDrink implements Item {
    @Override
    public Packing packge() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
