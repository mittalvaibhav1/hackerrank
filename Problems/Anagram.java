//https://www.hackerrank.com/challenges/anagram/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        int size = s.length();
        int changes = 0;
        if(size % 2 != 0) {
            return -1;
        }
        int index[] = new int[26];
        int end = size -1;
        for(int start = 0 ; start < end ; start++ , end-- ) {
            index[s.charAt(start) - 'a']++;
            index[s.charAt(end) - 'a']--;
        }
        for(int i : index) {
            //System.out.println(i);
            if(i != 0) {
                changes+=Math.abs(i);
            }
        }
        return changes/2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
