package dev.aman.backendapplicationsst.services;

import dev.aman.backendapplicationsst.dtos.FakeStoreCartDTO;
import dev.aman.backendapplicationsst.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreCartService")
public class FakeStoreCartService implements CartService{

    private RestTemplate restTemplate = new RestTemplate();

    private Cart convertFakeStoreCartDTOtoCart(FakeStoreCartDTO fakeStoreCartDTO){
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDTO.getId());
        cart.setUserId(fakeStoreCartDTO.getUserId());
        cart.setDate(fakeStoreCartDTO.getDate());
        cart.setProducts(fakeStoreCartDTO.getProducts());
        return cart;
    }

    private FakeStoreCartDTO convertCartToFakeStoreCartDTO(Cart cart){
        FakeStoreCartDTO fakeStoreCartDTO = new FakeStoreCartDTO();
        fakeStoreCartDTO.setId(cart.getId());
        fakeStoreCartDTO.setUserId(cart.getUserId());
        fakeStoreCartDTO.setDate(cart.getDate());
        fakeStoreCartDTO.setProducts(cart.getProducts());
        return fakeStoreCartDTO;
    }
    @Override
    public List<Cart> getAllCarts() {
        FakeStoreCartDTO[] fakeStoreCartDTOs = restTemplate.getForObject("https://fakestoreapi.com/carts"
                ,FakeStoreCartDTO[].class);

        if(fakeStoreCartDTOs != null){
            List<Cart> allCarts = new ArrayList<>();

            for(FakeStoreCartDTO fakeStoreCartDTO : fakeStoreCartDTOs){

                Cart currentCart = convertFakeStoreCartDTOtoCart(fakeStoreCartDTO);
                allCarts.add(currentCart);

            }

            return allCarts;
        }
        return null;
    }

    @Override
    public Cart getSingleCart(Long id) {

        FakeStoreCartDTO fakeStoreCartDTO = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id
                ,FakeStoreCartDTO.class);
        if(fakeStoreCartDTO != null){
            return convertFakeStoreCartDTOtoCart(fakeStoreCartDTO);
        }

        return null;
    }


    @Override
    public Cart createCart(Cart cart) {
        FakeStoreCartDTO fakeStoreCartDTO = convertCartToFakeStoreCartDTO(cart);
        FakeStoreCartDTO fakeStoreCartDTOOutput = restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                fakeStoreCartDTO,
                FakeStoreCartDTO.class
        );
        return convertFakeStoreCartDTOtoCart(fakeStoreCartDTOOutput);
    }

    @Override
    public void UpdateCart(Long id) {
        FakeStoreCartDTO fakeStoreCartDTO = convertCartToFakeStoreCartDTO(getSingleCart(id));
        restTemplate.put(
                "https://fakestoreapi.com/carts/" + id,
                fakeStoreCartDTO,
                FakeStoreCartDTO.class
        );
    }

}