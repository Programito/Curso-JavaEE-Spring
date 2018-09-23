package com.progra.practica4;

import java.util.ArrayList;

import com.progra.practica4.entities.Purchase;
import com.progra.practica4.entities.Storehouse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Storehouse store;
//        store=new Storehouse();
//        store.addProduct("milk", 3, 10);
//        store.addProduct("coffee", 5, 7);
//        
//        System.out.println("prices:");
//        System.out.println("milk: " + store.price("milk") );
//        System.out.println("coffee: " + store.price("coffee") );
//        System.out.println("Sugar: " + store.price("sugar") );
//        
//        store=new Storehouse();
//        store.addProduct("coffee", 5, 1);
//        store.addProduct("milk", 3, 10);
//        
//        System.out.println("stocks");
//        System.out.println("coffee: " + store.stock("coffee") );
//        System.out.println("sugar: " + store.stock("sugar") );
//        
//        System.out.println("We take a cofee " + store.take("coffee"));
//        System.out.println("We take a cofee " + store.take("coffee"));
//        System.out.println("We take a sugar " + store.take("sugar"));
//        
//        System.out.println("stocks");
//        System.out.println("coffee: " + store.stock("coffee") );
//        System.out.println("sugar: " + store.stock("sugar") );
//        
        
//        store=new Storehouse();
//        store.addProduct("milk", 3, 10);
//		store.addProduct("coffee", 5, 6);
//		store.addProduct("buttermilk", 2, 20);
//		store.addProduct("jogurt", 2, 20);
//        
//        for(String product:store.products()){
//        	System.out.println(product);
//        }
        
        Purchase purchase= new Purchase("milk",4,2);
        System.out.println("the total price of a purchase containing four milks is " + purchase.price() );
        System.out.println(purchase);
        purchase.increaseAmount();
        System.out.println(purchase);

        
    }
}
