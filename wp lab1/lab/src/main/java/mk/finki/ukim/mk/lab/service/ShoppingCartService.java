package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    void createShoppingCart();

    ShoppingCart getShoppingCartByUserId(Long id);
}
