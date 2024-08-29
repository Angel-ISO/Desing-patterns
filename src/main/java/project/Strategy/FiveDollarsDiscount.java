package project.Strategy;

public class FiveDollarsDiscount implements Descount {
    public double getDiscount(double price) {
        return price -5.0;  // 5$ of discount applied
    }
}
