package patternpractise.creational.abstractfactory;


public class WoodenDoor implements Door {
    @Override
    public String getDescription() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "WoodenDoor{}";
    }
}
