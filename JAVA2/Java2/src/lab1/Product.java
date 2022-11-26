
package lab1;


public class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getImportTax(){
        return getPrice()*0.1;
    }
    public void inRaThongTin(){
        System.out.println("Name: " + getName() + " Price: " + getPrice() + " Thue: " +getImportTax());
    }
    
    
}
