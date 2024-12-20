package org.example;

public class Customer implements Runnable{
    private Stock stock ;
    private String name ;

    public Customer(String name , Stock stock ) {
        this.stock = stock ;
        this.name = name  ;
    }

    @Override
    public void run() {
        Product product = null;
        try {
            product = this.stock.getProduct();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " got : " + product.getName() );
    }
}
