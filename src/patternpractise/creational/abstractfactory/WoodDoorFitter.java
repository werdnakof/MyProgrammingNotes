package patternpractise.creational.abstractfactory;

public class WoodDoorFitter implements DoorFitter {
    @Override
    public String getDescription() {
        return "I fit wood doors only.";
    }
}