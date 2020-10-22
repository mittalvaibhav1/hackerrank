//https://www.hackerrank.com/challenges/cut-the-sticks/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        int[] res = new int[arr.length];
        int min = Integer.MAX_VALUE;
        int k = 0;
        //Finding Minimum
        for(int i : arr) {
            min = Math.min(i,min);   
        }
        //Cutting Sticks. 
        for(int i = 0 ; i < arr.length ; i++) {
            int newMin = Integer.MAX_VALUE;
            int changes = 0;
            for(int j = 0 ; j < arr.length ; j++) {
                if(arr[j]!=0) {
                    arr[j]-=min;
                    changes++;
                }
                if(arr[j]!=0) {
                    newMin = Math.min(newMin,arr[j]);
                }
            }
            if(changes == 0) break;
            min = newMin;
            res[k++] =  changes;
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++) {
            ans[i] = res[i];
        } 
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
