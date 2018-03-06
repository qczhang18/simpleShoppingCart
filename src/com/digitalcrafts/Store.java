package com.digitalcrafts;

import java.util.HashMap;

public class Store {

    private HashMap<Product, Integer> productInventory;

    public Store(HashMap<Product, Integer> productInventory) {
        this.productInventory = productInventory;
    }

    public void addItem(Product product, Integer qty){
        if (productInventory.containsKey(product)){
            Integer currQty = productInventory.get(product);
            productInventory.replace(product, currQty+qty);
        }
        else{
            productInventory.put(product, qty);
        }
    }

    public void removeItem(Product product, Integer qty){
        if (productInventory.containsKey(product) && productInventory.get(product) >= qty){
            Integer currQty = productInventory.get(product);
            productInventory.replace(product, currQty-qty);
        }
        else {
            System.out.println("WARNING!!! Not Enough Inventory");
        }
    }

    public void viewInventory(){
        for (HashMap.Entry<Product, Integer> entry : productInventory.entrySet()) {
            String productName = entry.getKey().getName();
            Integer qty = entry.getValue();
            System.out.println("Product = " + productName + ", InventoryQty = " + qty);
        }
    }
}
