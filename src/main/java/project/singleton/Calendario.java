package project.singleton;

public class Calendario {
    private static  Calendario instance = new Calendario("Miercoles");
    public String dia;
    public int año=2024;

    private Calendario(String valor){
        this.dia=valor;
    }

    // y aqui se puede acceder a la instancia de la clase
    public static Calendario getInstance(){
        return instance;
    }


}
