package clases;

public class Order {
    
    //ATTRIBUTES
    private int idOrder;
    private Product products[];
    private static int countOrders;
    private int counterProducts;
    private static final int MAX_PRODUCTS = 10;
    
    //CONSTRUCTOR
    public Order(){
        this.idOrder = ++Order.countOrders;
        this.products = new Product[Order.MAX_PRODUCTS];
    }
    //METHODS
    public void addProduct(Product product){
        if(this.counterProducts < Order.MAX_PRODUCTS){
            products[counterProducts++] = product; 
        }else{
            System.out.println("You've reached maximun products: " + Order.MAX_PRODUCTS);
        }
    }
    public double calculateTotal(){
        double total = 0;
        for (int i = 0; i < this.counterProducts; i++){
            total += this.products[i].getPrice();
        }
        return total;
    }
    public void showOrder(){
        System.out.println("Id: " + this.idOrder);
        double totalPrice = this.calculateTotal();
        System.out.println("Total price: $" + totalPrice);
        System.out.println("Products: ");
        for (int i = 0; i < this.counterProducts; i++) {
            System.out.println(this.products[i]);
        }
    }
    //GETTERS & SETTERS
    
    
    //TOSTRING
}
