package patternpractise.creational.singleton;

import patternpractise.creational.prototype.Shape;
import patternpractise.creational.prototype.ShapeCache;

public class Client {
    public static void main(String[] args) {
        President president1 = President.getInstance();
        President president2 = President.getInstance();
        System.out.println(president1.hashCode() == president2.hashCode());
    }
}
