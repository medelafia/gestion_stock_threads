package org.example;

import javax.swing.plaf.IconUIResource;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Provider implements Runnable  {
    private String name ;
    private Stock stock ;
    public Provider(String name , Stock stock ) {
        this.name = name ;
        this.stock = stock ;
    }

    public String getName() {
        return name;
    }

    public void run() {
        System.out.println(this.name + " adding product now");
        Random random = new Random( );

        String randomName = UUID.randomUUID().toString() ;
        float randomPrice = random.nextFloat() ;

        try {
            this.stock.addProduct(new Product(randomName, randomPrice ));
            Thread.sleep(700);
            System.out.println("-------------------------------------");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
