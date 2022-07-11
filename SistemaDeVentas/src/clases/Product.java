package clases;

public class Product {
    
//ATTRIBUTES
    final private int idProduct; 
    private String name; 
    private double price;
    private static int counterProducts;
    
    //CONSTRUCTORS
    public Product(){
        this.idProduct = ++Product.counterProducts;
    }
    public Product(String name, double price){
        this();
        this.name = name;
        this.price = price;
    }
    
    //GETTERS & SETTERS
    public int getIdProduct() {
        return this.idProduct;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("idProduct=").append(idProduct);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }  
}
