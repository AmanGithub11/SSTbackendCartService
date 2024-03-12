package dev.aman.api_sst.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class product {
    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
}
