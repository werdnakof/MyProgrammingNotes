package patternpractise.Structural.decorator;

public class MilkCoffee implements Coffee {

    Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Double getCost() {
        return coffee.getCost() + 2.00;
    }

    @Override
    public String getDescription() {
        return "Milk " + coffee.getDescription();
    }
}
