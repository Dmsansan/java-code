package designType.main.com.sansan.cn.Factory;

public class FactoryTest {

    public static void main(String[] args) {
        Creator factory = new ConcreteCreator();
        Product product1 = factory.createProduct(ConCreateProduct1.class); //通过不同的类创建不同的产品
        Product product2 = factory.createProduct(ConCreateProduct2.class);
        /*
         * 下面继续其他业务处理
         */
        product1.method2();
    }
}
