//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int length = s.length();
        int sum = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < length ; i++ ) {
            for(int j = i ; j < length ; j++ ) {
                char[] stringToArray = s.substring(i,j+1).toCharArray();
                Arrays.sort(stringToArray);
                String key = String.valueOf(stringToArray);
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            sum += ((val-1) * val) / 2; 
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
