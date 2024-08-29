package project.Strategy;

public class Product {
    private String name;
    private double price;
    private Descount descount;

    public Product( Descount descount) {
        this.descount = descount;
    }

    public double CalculateDiscount(double price) {
        return descount.getDiscount(price);
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
}
