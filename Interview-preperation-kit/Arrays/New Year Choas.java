//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int minBribes = 0;
        int flag = 0;
        int process[] = new int[q.length];
        int index[] = new int[q.length+1];
        for(int i = 0 ; i < q.length ; i++ ) {
            process[i] = i+1;
            index[i+1] = i;
        }
        for(int i = 0 ; i < q.length ; i++ ) {
            if(q[i]!=process[i]) {
                if((index[q[i]]- i)>2) {
                    flag = 1;
                    break;
                }
                else {
                    for(int j = index[q[i]] ; j > i ; j--) {
                        index[process[j]]=j-1;
                        index[process[j-1]]=j;
                        int tmp = process[j];
                        process[j] = process[j-1];
                        process[j-1] = tmp; 
                        minBribes++;
                    }
                }
            }
        }
        if(flag == 1) {
            System.out.println("Too chaotic");
        }
        else {
            System.out.println(minBribes);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
