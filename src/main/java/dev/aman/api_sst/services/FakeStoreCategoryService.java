package dev.aman.api_sst.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCategoryService implement CategoryService{
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Category> getAllCategories() {
        String[] fakeStoreCategories = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );

        if (fakeStoreCategories != null) {
            List<Category> categories = new ArrayList<>();
            for (String category : fakeStoreCategories) {
                Category category1 = new Category();
                category1.setName(category);
                categories.add(category1);
            }

            return categories;
        }

        return null;
    }

}

