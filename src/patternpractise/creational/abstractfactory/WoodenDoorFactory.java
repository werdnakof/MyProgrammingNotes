package patternpractise.creational.abstractfactory;

public class WoodenDoorFactory implements DoorFactory {

    @Override
    public Door makeDoor() {
        return new WoodenDoor();
    }

    @Override
    public DoorFitter getDoorFitter() {
        return new WoodDoorFitter();
    }
}
