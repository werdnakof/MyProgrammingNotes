package patternpractise.structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public Double getCost() {
        return 10.00;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
