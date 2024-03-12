package dev.aman.api_sst.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private  CategoryService categoryService;

    public CategoryController(CategoryService categoryService){

        public CategoryController(CategoryService categoryService){
            this.categoryService = categoryService;

        }
        @GetMapping("/ products/categories")
        public List<Category> getAllCategories(){

            return categoryService.getAllCategories();
        }
    }
}
