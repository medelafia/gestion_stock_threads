package org.example;

import java.util.Scanner;
import java.util.Stack;

public class Provider implements Runnable  {
    private String name ;
    private Stock stock ;
    public Provider(String name , Stock stock ) {
        this.name = name ;
        this.stock = stock ;
    }
    public void run() {
            Scanner scanner = new Scanner(System.in) ;

            System.out.println("enter a product (ex : name price) ");

            String name = scanner.next() ;
            float price = Float.parseFloat(scanner.next()) ;

            try {
                this.stock.addProduct(new Product(name , price ));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
