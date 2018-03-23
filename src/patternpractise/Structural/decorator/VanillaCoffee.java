package patternpractise.Structural.decorator;

public class VanillaCoffee implements Coffee{

    Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Double getCost() {
        return coffee.getCost() + 5.00;
    }

    @Override
    public String getDescription() {
        return "Vanilla " + coffee.getDescription();
    }
}
