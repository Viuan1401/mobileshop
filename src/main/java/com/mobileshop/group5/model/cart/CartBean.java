package com.mobileshop.group5.model.cart;

import java.util.HashMap;

public class CartBean extends HashMap {
    public CartBean() {
        super();
    }

    public void addProduct(Cart cart) {
        int productId = cart.getProduct().getProductId();
        if (this.containsKey(productId)) {
            int oldQuantity = cart.getQuantity();
            ((Cart) this.get(productId)).setQuantity(++oldQuantity);
        } else {
            this.put(productId, cart);
        }
    }

    public boolean removeProduct(int productId) {
        if (this.containsKey(productId)) {
            this.remove(productId);
            return true;
        }
        return false;
    }

    public float getTotal(){
        float total = 0;
        for (Object object:this.values()){
            Cart cart = (Cart) object;
            total += cart.getProduct().getPrice()*cart.getQuantity();
        }
        return total;
    }
}
