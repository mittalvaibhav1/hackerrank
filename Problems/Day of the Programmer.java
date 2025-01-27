//https://www.hackerrank.com/challenges/day-of-the-programmer/problem
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

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String res = "";
        if(year == 1918) {
            return "26.09.1918";
        }
        if(year > 1917) {
            res = isGLeapYear(year) ?  "12.09." + year : "13.09." + year;
        }
        else  {
            res = isJLeapYear(year) ?  "12.09." + year : "13.09." + year;
        }
        return res;
    }
    static boolean isGLeapYear(int i) {
        return ((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0)));
    }
    static boolean isJLeapYear(int i) {
        return (i % 4 == 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
