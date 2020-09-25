//https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
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

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long,TreeMap<Long,Long>> map = new HashMap<>();
        long res = 0L;
        long ind = 0L;
        for(long i : arr) {
            if(map.containsKey(i)) {
                TreeMap<Long,Long> temp = map.get(i);
                temp.put(ind,(long)(temp.size()+ 1L));
            }
            else {
                TreeMap<Long,Long> temp = new TreeMap<>();
                temp.put(ind,1L);
                map.put(i,temp);
            }
            ind++;
        }
        ind = 0;
        for(long i : arr) {
            if(i%r==0 && map.containsKey(i/r) && map.containsKey(i*r)) {
                long j=0,k=0,c1=0,c2=0;  
                TreeMap<Long,Long> temp;
                try{
                    temp = map.get(i/r);
                    j = temp.floorKey(ind-1L);
                    c1 = temp.get(j);
                    temp = map.get(i*r);
                    k = temp.ceilingKey(ind+1L);
                    c2 = (temp.size()-temp.get(k))+1L;
                }
                catch(Exception ex) {
                    c1=0;
                    c2 =0;
                }
                res+=(c1*c2);
            }
            ind++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
