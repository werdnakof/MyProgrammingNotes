package competitor_handbook.complete_search;

import java.util.*;

public class MeetInTheMiddle {


    /**
     * Meet in the middle method
     *
     * Similar to GenSubSets, but split into two array and join them together
     *
     * Goal is to find a subset which sums to a target value
     *
     * e.g. [2, 4, 5, 9] target is 15
     * solution: [2, 4, 9]
     *
     * 1. split into two groups [2, 4] and [5, 9]
     * 2. find all possible subsets for each one, and their sums
     * 3. find matching subsets from each group which sums to target
     *
     * See page 64 in competitive handbook
     *
     * @param values
     * @param target
     * @param results
     */
    public static void meetInMiddle(int[] values,
                                    int target,
                                    List<List<Integer>> results) {
        if(values.length == 0) return;

        int mid = values.length / 2;
        int[] first = Arrays.copyOfRange(values, 0, mid);
        int[] second = Arrays.copyOfRange(values, mid, values.length);

        HashMap<Integer, List<List<Integer>>> sums1 = new HashMap<>();
        HashMap<Integer, List<List<Integer>>> sums2 = new HashMap<>();

        search(first, 0, new ArrayList<>(), sums1);
        search(second, 0, new ArrayList<>(), sums2);

        for(Map.Entry<Integer, List<List<Integer>>> entry: sums1.entrySet()) {
            Integer _sum = entry.getKey();

            if(sums2.containsKey(target-_sum)) {
                List<List<Integer>> entry2 = sums2.get(target-_sum);
                for(List<Integer> l : entry.getValue()) {
                    for(List<Integer> k : entry2) {
                        ArrayList<Integer> result = new ArrayList<>(l);
                        result.addAll(k);
                        results.add(result);
                    }
                }
            }
        }
    }

    public static void search(int[] values,
                              int index,
                              List<Integer> list,
                              HashMap<Integer, List<List<Integer>>> sums) {

        if(values.length == index) {
            int sum = 0;
            for(Integer i: list) sum += i;
            List<List<Integer>> v = sums.getOrDefault(sum, new ArrayList<>());
            v.add(new ArrayList<>(list));
            sums.put(sum, v);
        } else {
            Integer num = values[index];
            list.add(num);
            search(values, index+1, list, sums);
            list.remove(list.size()-1);
            search(values, index+1, list, sums);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        int[] values = new int[] {2, 4, 5, 9};
        meetInMiddle(values, 15, results);

        for(List<Integer> re: results) {
            System.out.println(re);
        }
    }
}
