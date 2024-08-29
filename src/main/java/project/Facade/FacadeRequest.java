package project.Facade;

public class FacadeRequest {
    private  Payout payout;
    private  Inventory inventory;
    private  Delivery delivery ;


    public FacadeRequest() {
        this.payout = new Payout();
        this.inventory = new Inventory();
        this.delivery = new Delivery();
    }

    public void dorequest(String item, int quantity) {
        if (inventory.isDisponible(item)) {
            System.out.println("Producto disponible, preparando pago");
            payout.pay(quantity);
            delivery.deliver(item);
        }
        else {
            System.out.println("No hay producto disponible");
        }
    }

}
