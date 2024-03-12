package dev.aman.api_sst.controllers;

import dev.aman.api_sst.models.product;
import dev.aman.api_sst.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService ProductService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<product> getAllProducts(){

        return productService.getAllproduct();
    }

    @GetMapping("/products/{id}")
    public product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody product product){
        return ProductService.createproduct(product);
    }

    @GetMapping("/products/category/{name}")
    public List<Product> getProductByCategory(@PathVariable("name") String name){

        return ProductService.getproductByCategory(name);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable("id") long id){
        productService.updateProduct(Product, id);

    }

}

art Service with API integration. You can continue developing and enhancing your project further.