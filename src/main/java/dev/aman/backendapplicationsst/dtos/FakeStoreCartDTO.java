package dev.aman.backendapplicationsst.dtos;

import dev.aman.backendapplicationsst.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FakeStoreCartDTO {
    private Long id;
    private Long userId;
    private String date;
    private List<Product> products;
}