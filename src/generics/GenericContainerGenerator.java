package generics;

import java.util.*;

public class GenericContainerGenerator {
    public static <K,V> Map<K,V> map() {
        return new HashMap<K,V>();
    }
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }
    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }
    public static <T> Set<T> set() {
        return new HashSet<T>();
    }
    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    static void f(Map<String, List<? super Coffee>> typeOfCoffee) {
        for(Map.Entry<String, List<? super Coffee>> gs: typeOfCoffee.entrySet()) {
            System.out.println(gs.getValue().get(0).getClass());
        }
    }

    static void s(Map<String, List<? extends Color>> typeOfCoffee) {
        for(Map.Entry<String, List<? extends Color>> gs: typeOfCoffee.entrySet()) {
            System.out.println(gs.getValue().get(0).getClass());
        }
    }

    public static void main(String[] args) {

        Map<String, List<String>> sls = GenericContainerGenerator.map();

        List<String> ls = GenericContainerGenerator.list();

        LinkedList<String> lls = GenericContainerGenerator.lList();

        Set<String> ss = GenericContainerGenerator.set();

        Queue<String> qs = GenericContainerGenerator.queue();


        Map<String, List<? super Coffee>> map = new HashMap<>();
        Coffee.Latte latte = new Coffee.Latte();
        List<? super Coffee> list = new ArrayList<>();
        list.add(latte);
        map.put("Latte", list);
        f(map);

//        List<? extends Color> list2 = new ArrayList<>();
//        list2.add(latte);
//        Map<String, List<? extends Color>> map2 = new HashMap<>();
//        map2.put("Latte", list2);
//         s(map2);
    }
}
