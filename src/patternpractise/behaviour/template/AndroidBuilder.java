package patternpractise.behaviour.template;

public class AndroidBuilder extends Builder{
    @Override
    String test() {
        return "Testing " + this.toString();
    }

    @Override
    String lint() {
        return "Linting " + this.toString();
    }

    @Override
    String assemble() {
        return "Assembling " + this.toString();
    }

    @Override
    String deploy() {
        return "Deploying " + this.toString();
    }

    @Override
    public String toString() {
        return "AndroidBuilder{}";
    }
}
