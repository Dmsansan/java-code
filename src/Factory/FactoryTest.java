package Factory;

public class FactoryTest {

    public static void main(String[] args) {
        //Creator factory = new ConcreteCreator();
        Product product1 = ConcreteCreator.createProduct(ConCreateProduct1.class); //通过不同的类创建不同的产品
        Product product2 = ConcreteCreator.createProduct(ConCreateProduct2.class);
        /*
         * 下面继续其他业务处理
         */
        product1.method2();
    }
}
