package thread.com.sansan.example;

/**
 * 生产者属性
 */
public class Product {
    private int id;

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }
}
