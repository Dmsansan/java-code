package thread.com.sansan.example;

public class Shop {
    int nIndex = 0;
    Product[] pro = new Product[10];

    public synchronized void addProduct(Product pd){
        while (nIndex == pro.length){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        this.notify();
        pro[nIndex] = pd;
        nIndex++;
    }

    public synchronized Product getProduct(){
        while (nIndex == 0){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        this.notify();
        nIndex--;
        return pro[nIndex];
    }
}
