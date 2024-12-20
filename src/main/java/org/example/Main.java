package org.example;

public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock() ;

        Provider provider = new Provider("provider1", stock );
        Provider provider1 = new Provider("provider 2" , stock ) ;
        Customer customer = new Customer("customer1" , stock );
        Customer customer1 = new Customer("customer2" , stock );

        Thread provider1Thread = new Thread(provider) ;
        Thread provider2Thread = new Thread(provider1) ;

        Thread customer1Thread = new Thread(customer) ;
        Thread customer2Thread = new Thread(customer1) ;

        customer1Thread.start();
        provider1Thread.start();

        provider2Thread.start();
        customer2Thread.start();
    }
}