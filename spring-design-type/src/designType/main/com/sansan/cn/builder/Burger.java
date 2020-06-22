package designType.main.com.sansan.cn.builder;

/**
 * 汉堡类
 */
public abstract class Burger implements Item {
    @Override
    public Packing packge() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

