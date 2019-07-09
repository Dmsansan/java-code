package thread.com.sansan.example;

/**
 * 生产者线程
 */
public class Producer implements Runnable {
    Shop shop;
    public Producer(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            Product product = new Product(i);
            shop.addProduct(product);
            System.out.println("生产了：" +product);

            try{
               Thread.sleep((long)(Math.random()*1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
