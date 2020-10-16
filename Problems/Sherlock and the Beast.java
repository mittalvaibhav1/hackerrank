//https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        StringBuilder res = new StringBuilder();
        int n5 = n;
        int n3 = 0;
        boolean flag = false;
        while(n5 >= 0 && n3 <= n) {
            if(n5 % 3 == 0 && n3 % 5 == 0) {
                flag = true;
                break;
            }
            else {
                n5-=5;
                n3+=5;
            }
        }
        if(flag) {
            while(n5-- > 0) {
                res.append(5);
            }
            while(n3-- > 0) {
                res.append(3);
            }
        }
        else {
            res = new StringBuilder("-1");
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
