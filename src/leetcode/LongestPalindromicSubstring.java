package leetcode;

public class LongestPalindromicSubstring {

    static int startInd;
    static int maxLength;
    public static String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        maxLength = Integer.MIN_VALUE;
        startInd = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length-1; i++) {
            checkPalindrome(chars, i, i); //odd
            if(i+1 < chars.length)
                checkPalindrome(chars, i, i+1); //even
        }
        return s.substring(startInd, startInd+maxLength-1);
    }

    public static void checkPalindrome(char[] chars, int left, int right) {
        while(left >= 0
                && right < chars.length
                && chars[left] == chars[right]) {
            left--;
            right++;
        }

        if(maxLength < right-left) {
            startInd = left+1;
            maxLength = right-left;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cc"));
    }
}
