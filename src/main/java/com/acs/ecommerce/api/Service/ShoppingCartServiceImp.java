package com.acs.ecommerce.api.Service;

import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService{
    private static final List<ShoppingCart> shoppingcarts = new ArrayList<>();

    public List<ShoppingCart> get() {
        return shoppingcarts;
    }

    /*public Quote getById(String idQuote) {
        Optional<Quote> optionalQuote = quotes.stream()
                .filter(quote -> quote.getId().equals(idQuote))
                .findFirst();

        return optionalQuote.orElse(null);
    }*/
}
