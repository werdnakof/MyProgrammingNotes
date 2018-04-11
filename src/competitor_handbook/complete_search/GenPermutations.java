package competitor_handbook.complete_search;

import java.util.ArrayList;
import java.util.List;

public class GenPermutations {

    public static void search(List<Integer> values,
                              List<Integer> list,
                              List<List<Integer>> results) {

        if(list.size() == values.size()) {
            results.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < values.size(); i++) {
                if(list.contains(values.get(i))) continue;
                list.add(values.get(i));
                search(values, list, results);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(5);
        values.add(6);
        search(values, list, results);
        for(List l: results) {
            System.out.println(l);
        }
    }
}
