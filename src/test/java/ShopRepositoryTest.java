import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Футболка", 5_000);
    Product product2 = new Product(23, "Юбка", 8_000);
    Product product3 = new Product(147, "Кроссовки", 24_000);
    Product product4 = new Product(54, "Куртка", 45_000);
    Product product5 = new Product(8, "Брюки", 10_000);

    @BeforeEach
    public void setup() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
    }

    @Test
    public void shouldRemoveProductById() {
        repo.remove(54);
        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductNoFoundId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(5);
        });
    }

}