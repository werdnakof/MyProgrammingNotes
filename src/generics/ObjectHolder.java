package generics;

import java.util.ArrayList;

public class ObjectHolder {
    private Object a;

    // ObjectHolder can hold any objects at run time after it has been initialized.
    public ObjectHolder(Object a) { this.a = a; }

    public void set(Object a) { this.a = a; }

    public Object get() { return a; }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new ArrayList<>());

        ArrayList a = (ArrayList) h2.get();

        h2.set("Not an ArrayList"); // String object

        String s = (String)h2.get();

        h2.set(1); // Autoboxes to Integer

        Integer x = (Integer)h2.get();
    }
}
