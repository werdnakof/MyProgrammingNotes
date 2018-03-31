package hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HourClass {

    /*
     * Complete the array2D function below.
     */
    static int array2D(int[][] arr) {
        int[][] result = new int[4][4];

        int largest = Integer.MIN_VALUE;
        for(int r = 0; r < 4; r++) {
            for(int c = 0; c < 4; c++) {
                int top = arr[r][c] + arr[r][c+1] + arr[r][c+2];
                int mid = arr[r+1][c+1];
                int bot = arr[r+2][c] + arr[r+2][c+1] + arr[r+2][c+2];
                int sum = top + mid + bot;
                result[r][c] = sum;
                if(sum > largest) largest = sum;
            }
        }

        return largest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int arrRowItr = 0; arrRowItr < 6; arrRowItr++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < 6; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }

        int result = array2D(arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}

