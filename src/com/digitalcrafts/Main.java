package com.digitalcrafts;


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Product airJordan = new Product("AirJordan XV", "Retro gold", 554);
    static Product lebronNew = new Product("Lebron new", "in high", 354);
    static Product curryNew = new Product("SteCurry", "aigght", 254);

    static HashMap<Product, Integer> storeProductInventory = new HashMap<Product, Integer>(){
        {
            put(airJordan, 10);
            put(lebronNew, 20);
            put(curryNew, 30);
        }
    };

    static Store qStore = new Store(storeProductInventory);
    static Cart qCart = new Cart();

    static boolean isGameOn = true;


    public static void main(String[] args) {

        while (isGameOn) {
            displayMenu();
        }
    }


    static void checkOut(){
        qCart.addItem(airJordan, 5);
        qStore.removeItem(airJordan,5 );
    }

    static void addItemToCart(){
        System.out.println("What would you like to add to cart?");
    }

    static void displayMenu(){
        System.out.println("Enter a Selection");
        System.out.println("1: View Store Products");
        System.out.println("2: View Cart");
        System.out.println("3: Add Item to Cart");
        System.out.println("4: Checkout");
        System.out.println("9: Thank you! BYE!");

        Scanner sc = new Scanner(System.in);
        int selectionNumber = sc.nextInt();
        switch (selectionNumber){
            case 1:
                qStore.viewInventory();
                break;
            case 2:
                if (qCart.getCartItems().isEmpty()){
                    System.out.println("***NOTHING in CART****");
                }
                else qCart.viewCartList();
                break;
            case 3:
                addItemToCart();
                break;
            case 4:
//                qStore.viewInventory();
//                qCart.viewCartList();
                checkOut();
//                System.out.println("*************************");
//                qStore.viewInventory();
//                qCart.viewCartList();
                break;
            case 9:
                System.out.println("Thank you! Come again! BYE!");
                isGameOn = false;
                break;
            default:
                System.out.println("Invalid Selection: Choose again");
                break;
        }
    }
}
