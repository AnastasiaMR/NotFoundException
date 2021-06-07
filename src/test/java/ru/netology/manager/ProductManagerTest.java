package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();

    private Product id1 = new Book(1, "Book", 1000, "Author", 10, 1950);
    private Product id2 = new Book(2, "Book2", 2000, "Author2", 20, 2000);
    private Product id3 = new TShirt( 3, "Nike", 500, "Blue", "S");
    private Product id4 = new TShirt(4, "Reebok", 1000, "Red", "M");

    @Test
    void removeByIdExist() {
        repository.save(id1);
        repository.save(id2);
        repository.save(id3);
        repository.save(id4);
        ProductManager manager = new ProductManager(repository);
        int id = 3;
        manager.removeById(id);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{id1, id2, id4};

        assertArrayEquals(actual, expected);


    }
    @Test
    void removeByIdNoExist() {
        repository.save(id1);
        repository.save(id2);
        repository.save(id3);
        repository.save(id4);
        ProductManager manager = new ProductManager(repository);
        int id = 5;

        assertThrows( NotFoundException.class, () -> manager.removeById(id));
    }

}