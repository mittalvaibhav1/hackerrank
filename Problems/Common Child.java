//https://www.hackerrank.com/challenges/common-child/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int commonChild(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        for(int i = 1 ; i < dp.length; i++) {
            for(int j = 1 ; j < dp[i].length ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
