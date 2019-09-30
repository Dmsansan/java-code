package thread.com.sansan.example;

/**
 * 消费者线程
 */
public class Consumer implements Runnable {
    Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            Product product = shop.getProduct();
            System.out.println("消费了：" + product);

            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
