package test;
import clases.*;

public class Test {
    public static void main(String[] args) {
        Product productOne = new Product("Remera",50.00);
        Product productTwo = new Product("Pantalón",90.00);
        
        Order orderOne = new Order();
        orderOne.addProduct(productOne);
        orderOne.addProduct(productTwo);
        orderOne.showOrder();
    }
}
