package patternpractise.creational.factory;

public class OfficeDoor implements Door {

    Double width;
    Double height;

    public OfficeDoor(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "OfficeDoor{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
