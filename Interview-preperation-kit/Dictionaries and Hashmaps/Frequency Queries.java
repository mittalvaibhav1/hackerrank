//https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
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

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> fc = new HashMap<>();
        for(int i = 0 ; i < queries.size() ; i++ ) {
            int op = queries.get(i).get(0);
            int val = queries.get(i).get(1);
            switch(op) {
                case 1:
                    if(map.containsKey(val)) {
                        int add = map.get(val)+1; 
                        map.put(val,add);
                        if(fc.get(add-1)==1) {
                            fc.remove(add-1);
                        }
                        else{
                            fc.put(add-1,fc.get(add-1)-1);
                        }
                        if(fc.containsKey(add)) {
                            fc.put(add,fc.get(add)+1);
                        }
                        else {
                            fc.put(add,1);
                        }
                    } 
                    else {
                        map.put(val,1);
                        if(fc.containsKey(1)) {
                            fc.put(1,fc.get(1)+1);
                        }
                        else {
                            fc.put(1,1);
                        }
                    }
                    break;
                case 2:
                    if(map.containsKey(val) && map.get(val)>0){
                        int remove = map.get(val)-1;
                        map.put(val,remove);

                        if(fc.get(remove+1)==1) {
                            fc.remove(remove+1);
                        }
                        else{
                            fc.put(remove+1,fc.get(remove+1)-1);
                        }
                        if(fc.containsKey(remove)) {
                            fc.put(remove,fc.get(remove)+1);
                        }
                        else {
                            fc.put(remove,1);
                        }
                    }
                    else {
                        map.remove(val);
                    }
                    break;
                case 3:
                    if(fc.containsKey(val)) {
                        res.add(1);
                    }
                    else {
                        res.add(0);
                    }
                    break;
            }
        }
        return res;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
