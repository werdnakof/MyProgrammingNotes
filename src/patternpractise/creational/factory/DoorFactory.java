package patternpractise.creational.factory;

public class DoorFactory {
    public static OfficeDoor makeOfficeDoor(Double width, Double height) {
        return new OfficeDoor(width, height);
    }

    public static  void main(String[] args) {
        System.out.println(DoorFactory.makeOfficeDoor(1.5, 5.0));
    }
}
