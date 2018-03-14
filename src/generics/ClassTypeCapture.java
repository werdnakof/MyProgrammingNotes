package generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String,Class<?>> map;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
        this.map = new HashMap<>();
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Class<?> kind) {
        this.map.put(typename, kind);
    }

    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        return map.getOrDefault(typename, Object.class).newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<Building>(Building.class);

        System.out.println(Arrays.toString(ctt1.getClass().getTypeParameters()));

        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<House>(House.class);

        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        ctt1.addType("fuck", String.class);
        System.out.println(ctt1.createNew("fuck").getClass().getName());
        System.out.println(ctt1.createNew("mum").getClass().getName());
    }
}

class Building {}
class House extends Building {}
