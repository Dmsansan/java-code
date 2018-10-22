package designType.main.com.sansan.cn.Adapter;

public class AdapterTest {
    public static void main(String[] args) {
//        Targetable targetable = new Adapter();
//        targetable.method1();
//        targetable.method2();
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }
}
