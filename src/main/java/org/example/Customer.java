package org.example;

public class Customer implements Runnable{
    private Stock stock ;
    private String name ;

    public Customer(String name , Stock stock ) {
        this.stock = stock ;
        this.name = name  ;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        Product product = null;
        try {
            product = this.stock.getProduct();
            System.out.println(this.name + " got : " + product.getName() );
            Thread.sleep(700);
            System.out.println("-------------------------------------------");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
