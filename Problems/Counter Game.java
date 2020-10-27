//https://www.hackerrank.com/challenges/counter-game/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the counterGame function below.
    static String counterGame(long n) {
        long turn = 0;
        turn += numberOfSetBits(n);
        turn += Long.numberOfTrailingZeros(n);
        if(turn % 2 == 1) return "Louise";
        return "Richard";
    }
    static int numberOfSetBits(long n) {
       int setBits = 0; 
       while(n != 0) {
           long check = (n & 1);
           if(check == 1) setBits++;
           n = (n >> 1); 
       }
       return setBits - 1; 
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
