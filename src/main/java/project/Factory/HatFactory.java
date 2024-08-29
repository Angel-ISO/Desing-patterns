package project.Factory;

public class HatFactory extends AcesoriesFactory {

    @Override
    public Acessories create() {
        return new Hat();
    }
}
