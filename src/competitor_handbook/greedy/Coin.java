package competitor_handbook.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coin {

    public static List<Integer> greedySearchMinCoins(int target, Integer[] options) {

        Integer[] coins = options.clone();

        // sort them so select largest everytime
        Arrays.sort(coins, (t1, t2) -> t2.compareTo(t1));

        result = new ArrayList<>();
        found = false;

        search(target, coins, new ArrayList<>());

        return result;
    }

    static Boolean found;
    static ArrayList<Integer> result;
    public static void search(int target,
                               Integer[] options,
                               List<Integer> list) {

        Integer sum = list.stream().mapToInt(Integer::intValue).sum();

        if(sum == target && !found) {
            found = true;
            result = new ArrayList<>(list);
        } else if(sum < target) {
            for(Integer opt: options) {
                if(sum+opt <= target) {
                    list.add(opt);
                    search(target, options, list);
                    list.remove(list.size()-1);
                    if(found) return;
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[] coins = new Integer[] {1, 2, 5, 10, 20,50, 200};

        Arrays.sort(coins, (t1, t2) -> t2.compareTo(t1));

        System.out.println(greedySearchMinCoins(520, coins));
    }
}
