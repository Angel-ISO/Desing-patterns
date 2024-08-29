package project.Strategy;

public class WithoutDiscount implements Descount {
    @Override
    public double getDiscount(double price) {
        return price; // no discount applied xDDDD
    }
}
