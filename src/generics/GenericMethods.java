package generics;

public class GenericMethods {
    public static <T> void fuck(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] vars) {
        GenericMethods.fuck("yourself");
    }
}
