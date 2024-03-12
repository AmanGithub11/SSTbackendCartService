package dev.aman.api_sst.services;

import dev.aman.api_sst.models.product;

import java.util.List;

public interface ProductService {

    List<product> getAllProduct();

    product getSingleProduct(long id);
    product createProduct(product product);
    List<product> getProductByCategory(String category);

    void deleteProduct(long id);

    void updateProduct(product product, long id);
}

