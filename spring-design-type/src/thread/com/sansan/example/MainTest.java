package thread.com.sansan.example;

public class MainTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread(new Producer(shop));
        t1.start();

        Thread t2 = new Thread(new Consumer(shop));
        t2.start();
    }
}
