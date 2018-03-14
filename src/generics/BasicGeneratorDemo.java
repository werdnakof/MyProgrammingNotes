package generics;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);

        // Also works
        // Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);

        for(int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}
