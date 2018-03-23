package patternpractise.behaviour.visitor;

public class Monkey implements Animal {
    @Override
    public void accept(AnimalOperation ao) {
        ao.visit(this);
    }

    public String beingABrat() {
        return "(Throw banana skin)";
    }
}
