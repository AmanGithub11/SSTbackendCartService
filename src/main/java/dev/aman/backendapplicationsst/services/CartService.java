package dev.aman.backendapplicationsst.services;
import dev.aman.backendapplicationsst.models.Cart;
import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getSingleCart(Long id);
    Cart createCart(Cart cart);
    void UpdateCart(Long id);

}