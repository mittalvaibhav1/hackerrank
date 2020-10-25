//https://www.hackerrank.com/challenges/plus-minus/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int total = arr.length;
        int negative = 0;
        int positive = 0;
        int zero = 0;
        for(int i : arr) {
            if(i < 0) negative++;
            else if(i > 0) positive++;
            else zero++;
        }
        System.out.printf("%.6f\n",positive/(double)total);
        System.out.printf("%.6f\n",negative/(double)total);
        System.out.printf("%.6f",zero/(double)total);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
