package generics;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public static class Latte extends Coffee implements Color {}

    public static class Mocha extends Coffee implements Color{}

    public static class Cappuccino extends Coffee implements Color{}

    public static class Americano extends Coffee implements Color{}

    public static class Breve extends Coffee implements Color{}
}
