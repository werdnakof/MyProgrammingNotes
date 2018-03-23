package patternpractise.creational.abstractfactory;

public class IronDoorFactory implements DoorFactory {

    @Override
    public Door makeDoor() {
        return new IronDoor();
    }

    @Override
    public DoorFitter getDoorFitter() {
        return new IronDoorFitter();
    }
}
