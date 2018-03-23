package patternpractise.creational.builder;

public class BurgerBuilder {
    public Integer size;
    public Boolean hasLettuce;
    public Boolean hasTomato;
    public Boolean hasPepperoni;
    public Boolean hasCheese;

    public BurgerBuilder setSize(Integer size) {
        this.size = size;
        return this;
    }

    public BurgerBuilder setHasLettuce(Boolean hasLettuce) {
        this.hasLettuce = hasLettuce;
        return this;
    }

    public BurgerBuilder setHasTomato(Boolean hasTomato) {
        this.hasTomato = hasTomato;
        return this;
    }

    public BurgerBuilder setHasPepperoni(Boolean hasPepperoni) {
        this.hasPepperoni = hasPepperoni;
        return this;
    }

    public BurgerBuilder setHasCheese(Boolean hasCheese) {
        this.hasCheese = hasCheese;
        return this;
    }
}
