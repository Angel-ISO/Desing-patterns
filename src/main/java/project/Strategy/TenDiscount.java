package project.Strategy;

public class TenDiscount implements Descount {
    @Override
    public double getDiscount(double price) {
        return price * 0.90; // 10% of discount applied
    }
}
