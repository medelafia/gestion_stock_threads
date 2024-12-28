package org.example;

import java.util.Stack;

public class Stock {
    private static Stock stock ;
    private static final int MAX_SIZE = 10 ;
    private static Stack<Product> products ;
    private Stock() {
        products = new Stack<>() ;
    }
    public synchronized void addProduct(Product product) throws InterruptedException {
        while( products.size() >= MAX_SIZE ) {
            System.out.println("stack is fully now , " +Thread.currentThread().getName() +" waiting for place to add his product ... ");
            wait();
        }
        products.push(product) ;
        System.out.println(Thread.currentThread().getName() + " product's is added to stock");
        notifyAll();
    }
    public synchronized Product getProduct() throws InterruptedException {
        while(products.isEmpty()) {
            System.out.println("the stack is empty now , customer " +Thread.currentThread().getName()+ " is waiting for products ...");
            wait();
        }
        System.out.println("you are received a product from the stock.");
        notifyAll();
        return products.pop() ;
    }
    public static Stock getInstance(){
        if( stock == null ){
            stock = new Stock() ;
        };
        return stock ;
    }
}
