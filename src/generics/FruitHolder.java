package generics;

public class FruitHolder<T> {
    private T value;
    public FruitHolder() {}
    public FruitHolder(T val) { value = val; }
    public void set(T val) { value = val; }
    public T get() { return value; }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    public static void main(String[] args) {
        FruitHolder<Apple> Apple = new FruitHolder<Apple>(new Apple());

        Apple d = Apple.get();

        Apple.set(d);

        // Holder<Fruit> Fruit = Apple; // Cannot upcast
        FruitHolder<? extends Fruit> fruit = Apple; // OK

        Fruit p = fruit.get();

        d = (Apple) fruit.get(); // Returns ‘Object’

        System.out.println(p.getClass().getName());
        System.out.println(d.getClass().getName());

        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch(Exception e) {
            System.out.println(e);
        }

        // fruit.set(new Apple()); // Cannot call set()
        // fruit.set(new Fruit()); // Cannot call set()

        System.out.println(fruit.equals(d)); // OK
    }
}
