package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class ListMaker<T> {
    ArrayList<T> arr;

    public ListMaker() {
        this.arr = new ArrayList<>();
    }

    public void add(T ele) {
        this.arr.add(ele);
    }

    public T getByIndex(int i) {
        return arr.get(i);
    }

    public static void main(String[] args) {
        ListMaker<String> strMaker= new ListMaker<>();
        System.out.println(Arrays.toString(strMaker.getClass().getTypeParameters())); // can't access type of String
        strMaker.add("hello");
        System.out.println(strMaker.getByIndex(0).getClass().getName());
    }
}