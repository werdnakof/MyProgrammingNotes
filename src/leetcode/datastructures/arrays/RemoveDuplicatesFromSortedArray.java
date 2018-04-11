package leetcode.datastructures.arrays;

public class RemoveDuplicatesFromSortedArray {
    public  static int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int count = 1;
        boolean twice = false;

        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(!twice || nums[i] != nums[i-1]) {
                tmp[count++] = nums[i];
            }
            twice = nums[i] == nums[i - 1];
        }

        for(int i = 0; i < count; i++) nums[i] = tmp[i];

        return count;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,1,2,2,3}));
    }
}
