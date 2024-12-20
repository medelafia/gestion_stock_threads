package org.example;

import java.util.Stack;

public class Stock {
    private static final int MAX_SIZE = 100 ;
    private final Stack< Product> products = new Stack<>();
    private boolean isAdding = false ;
    public synchronized void addProduct(Product product) throws InterruptedException {
        while( products.size() >= this.MAX_SIZE ) {
            System.out.println("stack is fully now");
            wait();
        }
        products.push(product) ;
        System.out.println("a new product is added");
        notifyAll();
    }
    public synchronized Product getProduct() throws InterruptedException {
        while(products.isEmpty()) {
            System.out.println("the stack is empty now");
            wait();
        }
        System.out.println("A client has received a product from the stock.");
        notifyAll();
        return products.pop() ;
    }
}
