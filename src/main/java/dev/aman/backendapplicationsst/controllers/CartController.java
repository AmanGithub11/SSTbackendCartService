package dev.aman.backendapplicationsst.controllers;

import dev.aman.backendapplicationsst.models.Cart;
import dev.aman.backendapplicationsst.services.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private CartService cartService;

    public CartController(@Qualifier("FakeStoreCartService") CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    Cart getSingleCart(@PathVariable ("id") Long id){
        return cartService.getSingleCart(id);
    }

    // create/add a new cart
    @PostMapping ("/carts")
    Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    // update a cart
    @PutMapping("/carts/{id}")
    void updateCart(@RequestBody Cart cart, @PathVariable("id") Long id){
        cartService.UpdateCart(id);
    }


}