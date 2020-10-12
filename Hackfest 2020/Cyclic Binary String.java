//https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/cyclic-binary-string/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static int maximumPower(String s) {
        int size = s.length();
        int zeros = 1;
        int res = 0;
        if(!s.contains("1")) return -1;
        if(!s.contains("0")) return 0;
        int zerosStart = 0;
        int zerosEnd = size - 1;
        while(s.charAt(zerosStart) == '0')
        {
            zerosStart++;
        }
        while(s.charAt(zerosEnd) == '0')
        {
            zerosEnd--;
        }
        zerosEnd = (size -1) - zerosEnd;
        res = zerosStart + zerosEnd;
        
        for(int i = 0 ; i < size - 1 ; i++)
        {   
            if(s.charAt(i) == '0' && s.charAt(i+1) == '0'){
                 zeros ++;
            }
            else{
                res = Math.max(res,zeros);
                zeros = 1;
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.maximumPower(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
