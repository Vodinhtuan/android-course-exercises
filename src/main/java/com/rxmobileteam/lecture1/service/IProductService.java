package com.rxmobileteam.lecture1.service;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IProductService {
    boolean addProduct (@NotNull Product product);
    @NotNull Set<Product> findAll();

}
