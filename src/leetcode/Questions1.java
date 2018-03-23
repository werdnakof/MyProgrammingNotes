package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Questions1 {

    public static int[] countBits(int num) {
        int[] results = new int[num+1];
        for(int i = 1; i <= num; i++) {
            if(results[i] > 0) continue;
            results = countBits(results, i, num);
        }
        return results;
    }

    public static int[] countBits(int[] results, int k, int limit) {
        int bitCount = 0;
        int kcopy = k;
        while(kcopy >= 1) {
            if(kcopy % 2 == 1) bitCount++;
            kcopy /= 2;
        }
        for(int i = k; i <= limit; i*=2) {
            results[i] = bitCount;
        }
        return results;
    }

    public static int[] countBitsBetter(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        Integer largest = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int left = i - 1 >= 0 ? nums[i-1] : 1;
            int right = i + 1 < nums.length ? nums[i+1] : 1;
            int count = nums[i] * left * right;
            int[] copy = copy(nums, i);
            int tmp = count + maxCoins(copy);
            largest = largest < tmp ? tmp : largest;
        }

        return largest;
    }

    public static int[] copy(int[] nums, int skip) {
        int[] ret = new int[nums.length-1];
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == skip) continue;
            ret[idx++] = nums[i];
        }
        return ret;
    }

    /**
     * Given a list of daily temperatures, produce a list that, for each day in the input,
     * tells you how many days you would have to wait until a warmer temperature.
     *
     * If there is no future day for which this is possible, put 0 instead.
     * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    // licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
    // steps

    // licensePlate = "1s3 456", words = ["looks", "pest", "stew", "generate"]
    // pest
    public static String shortestCompletingWord(String licensePlate, String[] words) {

        int[] plate = new int[26];
        int length = 0;

        for(int c: licensePlate.toCharArray()) {
            if(c >= 97 && c <= 122) {
                plate[c-97] += 1;
                length++;
            }

            if(c >= 65 && c <= 90) {
                plate[c-65] += 1;
                length++;
            }
        }

        String bestword = null;
        for(String word: words) {
            int count = 0;
            int[] plateclone = plate.clone();
            for(int c: word.toLowerCase().toCharArray()) {
                if(plateclone[c-97] > 0) {
                    plateclone[c-97]-=1;
                    count++;
                }
            }

            if(count == length && (bestword == null || word.length() < bestword.length())) bestword = word;
        }

        return bestword;
    }

    public static void main(String[] args) {
//        char a = 'a';
//        char z = 'z';
//        char A = 'A';
//        char Z = 'Z';
//        System.out.println((int)a);
//        System.out.println((int)z);
//        System.out.println((int)A);
//        System.out.println((int)Z);
        System.out.println(shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "generate"}));
    }
}
