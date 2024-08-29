package project.Factory;

public class GlovesFactory extends AcesoriesFactory {
    @Override
    public Acessories create() {
        return new Gloves();
    }
}
