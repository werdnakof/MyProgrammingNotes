package generics;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

class GenericBase<K> {
    private K element;
    public void set(K arg) { element = arg; }
    public K get() { return element; }
}

class Derived1<T> extends GenericBase<T> {}

class Derived2 extends GenericBase {} // No warning

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived1<String> d1 = new Derived1<>();
        d1.set("hello");
        TypeVariable<? extends Class<? extends Derived1>>[] typeParams1 = d1.getClass().getTypeParameters();
        System.out.println(typeParams1[0]);

        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj); // Warning here if annotation is removed
        TypeVariable<? extends Class<? extends Derived1>>[] typeParams2 = d1.getClass().getTypeParameters();
        System.out.println(Arrays.toString(typeParams2));
    }
}