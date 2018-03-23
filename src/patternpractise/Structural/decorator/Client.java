package patternpractise.Structural.decorator;

public class Client {
    public static void main(String[] vargs) {
        SimpleCoffee sc = new SimpleCoffee();

        MilkCoffee mc = new MilkCoffee(sc);
        VanillaCoffee vc = new VanillaCoffee(new Coffee() {
            @Override
            public Double getCost() {
                return 20.00;
            }

            @Override
            public String getDescription() {
                return "Random Coffee";
            }
        });

        System.out.println(mc.getDescription());
        System.out.println(vc.getDescription());
    }
}
