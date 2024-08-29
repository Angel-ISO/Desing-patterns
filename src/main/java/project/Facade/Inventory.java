package project.Facade;

public class Inventory {

    public boolean isDisponible(String item) {
        System.out.println("Comprobacion de la disponibilidad para {" + item + "}");
        return true;
    }
}
