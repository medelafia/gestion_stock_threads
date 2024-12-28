package org.example;

import java.util.Scanner;

public class Main {
    public static void executeProvider() {
        Scanner scanner = new Scanner(System.in);
        Stock stock = Stock.getInstance() ;
        System.out.println("enter the provider name");
        String providerName = scanner.nextLine() ;
        Provider provider = new Provider(providerName , stock ) ;
        new Thread(provider).start();
    }
    public static void executeCustomer() {
        Scanner scanner = new Scanner(System.in);
        Stock stock = Stock.getInstance() ;
        System.out.println("enter the customer name");
        String customerName = scanner.nextLine() ;
        Customer customer = new Customer(customerName , stock);
        Thread thread = new Thread(customer) ;
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Stock stock = Stock.getInstance() ;

        Provider provider = new Provider("provider1" , stock ) ;

        Customer customer = new Customer("customer1" , stock );

        for(int i = 0 ; i < 12 ; i++)  {
            new Thread(provider , provider.getName() ).start();
            Thread.sleep(1000);
        }

        for(int i = 0 ; i < 10 ; i++ ) {
            new Thread(customer , customer.getName()).start();
            Thread.sleep(1000);
        }

    }
}
