//https://www.hackerrank.com/challenges/palindrome-index/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        char[] arr = s.toCharArray();
        int index = check(arr,0,arr.length-1,false,-1);
        return index;
    }
    static int check(char[] arr,int start,int end , boolean remove ,int index) {
        if(start < end) {
            if(arr[start] == arr[end]) {
                return check(arr,start+1,end-1,remove,index);
            }
            else if(!remove) {
                remove = true;
                return Math.max(check(arr,start+1,end,remove,start),check(arr,start,end-1,remove,end));
            }
            else {
                return -1;
            }
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
