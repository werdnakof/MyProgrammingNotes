package patternpractise.creational.abstractfactory;

public class Client {
    public static void main(String[] args) {
        DoorFactory[] doorFactories = new DoorFactory[] { new IronDoorFactory(), new WoodenDoorFactory() };
        for(DoorFactory doorFactory: doorFactories) {
            System.out.println(doorFactory.makeDoor().getDescription());
            System.out.println(doorFactory.getDoorFitter().getDescription());
        }
    }
}
