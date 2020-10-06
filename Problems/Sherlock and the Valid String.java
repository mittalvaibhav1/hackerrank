//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] index = new int[26];
        for(char i : s.toCharArray()) {
            index[i-'a']++;
        }
        int diff = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++) {
            if(index[i]==0) continue;
            diff++;
            map.put(index[i],map.getOrDefault(index[i],0)+1);
        }
        if(map.size() > 2) {
            return "NO";
        }
        else if(map.size() == 2) {
            Iterator<Integer> it = map.keySet().iterator();
            int a = it.next();
            int b = it.next();
            if(Math.max(map.get(a),map.get(b)) != diff - 1) {
                return "NO";
            }
            if(map.get(Math.min(a,b))!=1  && Math.abs(a-b)!=1) {
                return "NO";
            }
        }
        return "YES";
       
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
