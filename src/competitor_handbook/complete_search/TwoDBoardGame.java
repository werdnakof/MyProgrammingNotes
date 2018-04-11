package competitor_handbook.complete_search;

public class TwoDBoardGame {

    public static int search(int pos,
                             int target,
                             int currentCount,
                             boolean[] horizontal,
                             boolean[] diag1,
                             boolean[] diag2) {
        if(pos == target) {
            return ++currentCount;
        } else {
            for(int i = 0; i < horizontal.length; i++) {
                if(horizontal[i] || diag1[i+pos] || diag2[i-pos+target-1]) continue;

                horizontal[i] = diag1[i+pos] = diag2[i-pos+target-1] = true;
                currentCount = search(pos+1, target, currentCount, horizontal, diag1, diag2);
                horizontal[i] = diag1[i+pos] = diag2[i-pos+target-1] = false;
            }
            return currentCount;
        }

    }

    public static void main(String[] args) {
        int target = 4;
        boolean[] horizontal = new boolean[target];
        boolean[] diag1 = new boolean[2*target-1];
        boolean[] diag2 = new boolean[2*target-1];
        System.out.println(search(0, target, 0, horizontal, diag1, diag2));
    }
}
