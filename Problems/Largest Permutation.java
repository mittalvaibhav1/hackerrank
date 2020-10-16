//https://www.hackerrank.com/challenges/largest-permutation/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            max = Math.max(max,arr[i]);
            map.put(arr[i],i);
        }
        for(int i = 0 ; i < k && i < arr.length ; i++) {
            if(arr[i] == max) k++;
            int j = map.get(max);
            map.put(max,i);
            map.put(arr[i],j);
            int tmp = arr[i];
            arr[i] = max;
            arr[j] = tmp;
            max--;
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
