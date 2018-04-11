package competitor_handbook.complete_search;

import java.util.ArrayList;
import java.util.List;

public class GenSubSets {

    /**
     * Is all about keep or not keep i.e. KnapSack
     *
     *
     * @param index
     * @param values
     * @param list
     * @param results
     */
    public static void search(int index, // index of the integer in values
                              List<Integer> values,
                              List<Integer> list,
                              List<List<Integer>> results) {

        if(index == values.size()) { // index has reached end of values
            results.add(new ArrayList<>(list));
        } else {

            // branch with integer
            list.add(values.get(index));
            search(index+1, values, list, results);

            // branch without integer
            list.remove(list.size()-1);
            search(index+1, values, list, results);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(5);
        values.add(6);
        search(0, values, list, results);
        for(List l: results) {
            System.out.println(l);
        }
    }
}
