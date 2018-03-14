package generics;

import java.util.ArrayList;

public class GenericHolder<T> {
    private T a;
    public GenericHolder(T a) { this.a = a; }
    public void set(T a) { this.a = a; }
    public T get() { return a; }

    public static void main(String[] args) {
        GenericHolder<ArrayList> h3 =
                new GenericHolder<ArrayList>(new ArrayList());

        ArrayList a = h3.get(); // No cast needed

        // h3.set("Not an Automobile"); // Error
        // h3.set(1); // Error
    }
}
