//https://www.hackerrank.com/challenges/flipping-bits/problem

// METHOD 2 BETTER
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        long toggler = 1;
        for(int i = 0 ; i < 32 ; i++) {
            n = (n ^ toggler);
            toggler = (toggler << 1);
        }
        return n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

// METHOD 1

// import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
// import java.util.*;
// import java.util.concurrent.*;
// import java.util.regex.*;

// public class Solution {

//     // Complete the flippingBits function below.
//     static long flippingBits(long n) {
//         long toggler = 1;
//         toggler =  (toggler << 31);
//         long ans = 0;
//         for(int i = 0 ; i < 32 ; i++) {
//             long bit = (n & toggler);
//             if(bit > 1) bit = 1;
//             bit = (bit ^ 1);
//             ans = (ans | bit);
//             ans = (ans << 1);
//             toggler = (toggler >> 1);
//         }
//         return (ans >> 1);
//     }

//     private static final Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) throws IOException {
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int q = scanner.nextInt();
//         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//         for (int qItr = 0; qItr < q; qItr++) {
//             long n = scanner.nextLong();
//             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//             long result = flippingBits(n);

//             bufferedWriter.write(String.valueOf(result));
//             bufferedWriter.newLine();
//         }

//         bufferedWriter.close();

//         scanner.close();
//     }
// }

