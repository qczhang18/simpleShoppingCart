package com.digitalcrafts;

import java.util.HashMap;

public class Cart {

    private HashMap<Product, Integer> cartItems = new HashMap<>();

    public HashMap<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void addItem(Product product, Integer qty){
        if (cartItems.containsKey(product)){
            Integer currQty = cartItems.get(product);
            cartItems.replace(product, currQty+qty);
        }
        else{

            cartItems.put(product, qty);
        }
    }

    public void removeItem(Product product, Integer qty){
        if (cartItems.containsKey(product) && cartItems.get(product) >= qty){
            Integer currQty = cartItems.get(product);
            cartItems.replace(product, currQty-qty);
        }
        else {
            System.out.println("Removing Item from Cart");
            cartItems.remove(product);
        }
    }

    public void viewCartList(){
        for (HashMap.Entry<Product, Integer> entry : cartItems.entrySet()) {
            String productName = entry.getKey().getName();
            Double itemPrice = entry.getKey().getPrice();
            Integer qty = entry.getValue();
            System.out.println("Product:" + productName + ", Price:" + itemPrice + ", InventoryQty:" + qty);
        }
    }

}
