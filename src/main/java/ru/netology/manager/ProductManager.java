package ru.netology.manager;

import lombok.Data;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

@Data

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void removeById(int id) throws NotFoundException {
        if (repository.findById(id)==null){
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {repository.removeById(id);
        }
    }
    }
