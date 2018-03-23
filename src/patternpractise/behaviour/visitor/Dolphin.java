package patternpractise.behaviour.visitor;

public class Dolphin implements Animal {
    @Override
    public void accept(AnimalOperation ao) {
        ao.visit(this);
    }

    public String leap() {
        return "(Jump out of water)";
    }
}
