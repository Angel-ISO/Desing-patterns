package project.Factory;

public class Main {

    public static void main(String[] args) {
        AcesoriesFactory acesoriesFactory = new GlovesFactory();
        Acessories glove = acesoriesFactory.create();
        glove.use();

        AcesoriesFactory hatFactory = new HatFactory();
        Acessories hat = hatFactory.create();
        hat.use();

    }

}
