//https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
        //Declarations...
        int countEach = gene.length() / 4 ;
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> unstableCount = new HashMap<>();
        char[] geneArray = gene.toCharArray();
        int ans = Integer.MAX_VALUE;
        int totalLength = 0;
        int currLen = 0;
        int start = 0;
        //Figuring out unstable count
        for(char i : geneArray) {
            int val = map.getOrDefault(i , 0) + 1;
            map.put(i,val);
            if(val > countEach) {
                unstableCount.put(i,val- countEach);
            }
        }
        //If stable
        if(unstableCount.size() == 0) return 0;
        //Else
        map = new HashMap<>();
        for(Map.Entry<Character,Integer> entry : unstableCount.entrySet()) {
            totalLength += entry.getValue();
        } 
        for(int i = 0 ; i < geneArray.length ; i++) {
            map.put(geneArray[i] , map.getOrDefault(geneArray[i] , 0) + 1);
            if(unstableCount.containsKey(geneArray[i])) {
                if(map.get(geneArray[i]) <= unstableCount.get(geneArray[i])) {
                    currLen++;
                }
            }
            if(currLen == totalLength) {
                while(!unstableCount.containsKey(geneArray[start]) || 
                map.get(geneArray[start]) > unstableCount.get(geneArray[start])) {
                    if(unstableCount.containsKey(geneArray[start]) && 
                map.get(geneArray[start]) > unstableCount.get(geneArray[start])) 
                     map.put(geneArray[start] ,map.get(geneArray[start])-1);
                     start++;
                }
                 ans = Math.min(i-start+1,ans);
            }
           
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
