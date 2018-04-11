package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement_leetcode(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        if(nums.length == 0) return list;

        int cnt1 = 1, cnt2 = 0, cand1 = nums[0], cand2 = nums[0];

        for(int val: nums) {
            if(val == cand1) cnt1++;
            else if(val == cand2) cnt2++;
            else if(cnt1 == 0) {
                cand1 = val;
                cnt1 = 1;
            }else if(cnt2 == 0) {
                cand2 = val;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int val : nums) {
            if(val == cand1)
                cnt1++;
            else if(val == cand2)
                cnt2++;
        }
        if(cnt1 > nums.length/3) list.add(cand1);
        if(cnt2 > nums.length/3) list.add(cand2);

        return list;
    }

    public static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int requiredFreq = nums.length / 3;

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int num: map.keySet()) {
            if(map.get(num) > requiredFreq) list.add(num);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
