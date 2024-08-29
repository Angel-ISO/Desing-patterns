package project.singleton;

public class main {
    public static void main(String[] args) {
        System.out.println(Calendario.getInstance().dia);
        System.out.println(Calendario.getInstance().año);
        Calendario.getInstance().año=2025;
        System.out.println(Calendario.getInstance().año);
        Calendario.getInstance().dia="Jueves";
        System.out.println(Calendario.getInstance().dia);
    }
}
