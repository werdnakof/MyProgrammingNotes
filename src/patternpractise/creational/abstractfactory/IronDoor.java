package patternpractise.creational.abstractfactory;

public class IronDoor implements Door {
    @Override
    public String getDescription() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "IronDoor{}";
    }
}
