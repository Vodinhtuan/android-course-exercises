package com.rxmobileteam.lecture1.service;

import com.rxmobileteam.lecture1.data.ProductDao;
import com.rxmobileteam.utils.ExerciseNotCompletedException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@link ProductService} provides an API that allows to manage {@link Product}s.
 * <p>
 * TODO: 1. Using {@link ProductDao} implement method {@link ProductService#addProduct(Product)}}
 * TODO: 2. Using {@link ProductDao} implement method {@link ProductService#searchProducts(String)}
 */
public class ProductService implements IProductService {
    ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Set<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(String id) {
        return productDao.getProduct(id);
    }

    /**
     * Adds a new product to the system.
     *
     * @param product a product to add
     * @return {@code true} if a product was added, {@code false} otherwise.
     */
    @Override
    public boolean addProduct(@NotNull Product product) {
        // TODO: implement this method
        if (productDao.add(product)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns all products that contains the given query in the name or description.
     *
     * @param query a search query
     * @return a list of found products
     */
    @Override
    public List<Product> searchProducts(String query) {
        // TODO: implement this method
        Set<Product> allProducts = productDao.findAll();
        return allProducts.stream()
            .filter(product -> product.getName().contains(query) || product.getDescription().contains(query))
            .collect(Collectors.toList());
    }
}
