package patternpractise.behaviour.visitor;

public class Lion implements Animal{
    @Override
    public void accept(AnimalOperation ao) {
        ao.visit(this);
    }

    public String sing() {
        return "(Sings Lion King Theme Song)";
    }
}
