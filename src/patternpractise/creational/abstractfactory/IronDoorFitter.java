package patternpractise.creational.abstractfactory;

public class IronDoorFitter implements DoorFitter {
    @Override
    public String getDescription() {
        return "I fit iron doors only.";
    }
}
