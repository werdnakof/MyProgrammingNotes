package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // Call with captured type
    }

    static void f3(Holder<? super Number> holder) {
        Object h = holder.get();
        System.out.println(h.getClass().getSimpleName());
    }

    static <T> void checkListType(List<T> list, int pos) {
        T v = list.get(pos);
        System.out.println(v.getClass().getName());
    }

    static void f4(Holder<List<?>> holder) {
        List list = holder.get();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        checkListType(list, 0);
        list.add("bb"); // unchecked warning
        checkListType(list, 1);
//        Integer in = list.get(1); // Error, erasure changes it to Object
    }

    static <T> void setListElement(List<T> list, int pos, T ele) {
        list.set(pos, ele);
        System.out.println(list.getClass().getName());
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Holder raw = new Holder<>(1);
        f1(raw); // Produces warnings
        f2(raw); // No warnings
        f3(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Warning
        f2(rawBasic); // No warnings
        f3(rawBasic);

        // Upcast to Holder<?>, still figures it out:
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
        // f3(wildcarded); // Error

        List list = new ArrayList<>();
        list.add(2);
        Holder rawList = new Holder(list);
        f4(rawList);
    }
}
