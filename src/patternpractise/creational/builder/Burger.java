package patternpractise.creational.builder;

public class Burger {
    public Integer size;
    public Boolean hasLettuce;
    public Boolean hasTomato;
    public Boolean hasPepperoni;
    public Boolean hasCheese;

    public Burger(BurgerBuilder burgerBuilder){
        this.size = size;
        this.hasLettuce = burgerBuilder.hasLettuce;
        this.hasTomato = burgerBuilder.hasTomato;
        this.hasPepperoni = burgerBuilder.hasPepperoni;
        this.hasCheese = burgerBuilder.hasCheese;
    }
}