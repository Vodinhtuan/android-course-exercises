package com.rxmobileteam.lecture1.data;

import com.rxmobileteam.lecture1.service.IProductService;
import com.rxmobileteam.lecture1.service.Product;
import com.rxmobileteam.utils.ExerciseNotCompletedException;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * {@link ProductDao} represents a Data Access Object (DAO) for products.
 * The implementation is simplified, so it just uses {@link HashSet} to store.
 * <p>
 * todo: 1. Implement a method {@link ProductDao#add(Product)} that store new product into the set
 * todo: 2. Implement a method {@link ProductDao#findAll()} that returns a set of all products
 */
public class ProductDao implements IProductService {
    private final Set<Product> products = new HashSet<>();
    /**
     * Stores a new product
     *
     * @param product a product to store
     * @return {@code true} if a product was stored, {@code false} otherwise
     */

    @Override
    public boolean addProduct(@NotNull Product product) {
        return products.add(product);
    }

    /**
     * Returns all stored products
     *
     * @return a set of all stored products
     */
    @NotNull
    public Set<Product> findAll() {
        // TODO: implement this method
        return new HashSet<>(products);
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
