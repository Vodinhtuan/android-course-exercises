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
public class ProductService {
    @NotNull
    private final IProductService productDao;

    public ProductService(@NotNull IProductService productDao) {
        this.productDao = productDao;
    }


    /**
     * Adds a new product to the system.
     *
     * @param product a product to add
     * @return {@code true} if a product was added, {@code false} otherwise.
     */
    public boolean addProduct(@NotNull Product product) {
        // TODO: implement this method
        return productDao.addProduct(product);
    }

    /**
     * Returns all products that contains the given query in the name or description.
     *
     * @param query a search query
     * @return a list of found products
     */

    public List<Product> searchProducts(String query) {
        // TODO: implement this method
        Set<Product> allProducts = productDao.findAll();
        return allProducts.stream()
            .filter(product -> product.getName().contains(query) || product.getDescription().contains(query))
            .collect(Collectors.toList());
    }
}
