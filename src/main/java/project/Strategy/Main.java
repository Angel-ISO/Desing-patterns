package project.Strategy;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(new TenDiscount());
        product.setName("pan");
        product.setPrice(100);
        System.out.println("decuento aplicado, el nuevo precio es \n$"+product.CalculateDiscount(100));

        product = new Product(new FiveDollarsDiscount());
        product.setName("pan");
        product.setPrice(100);
        System.out.println("decuento aplicado, el nuevo precio es \n$"+product.CalculateDiscount(100));

        product = new Product(new WithoutDiscount());
        product.setName("pan");
        product.setPrice(100);
        System.out.println("sin decuento, el nuevo precio es \n$"+product.CalculateDiscount(100));
    }
}
