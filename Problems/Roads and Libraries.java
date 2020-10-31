//https://www.hackerrank.com/challenges/torque-and-development/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_lib <= c_road) return n * 1l * c_lib;
        Graph g = new Graph(n);
        for(int[] i : cities) {
            g.addEdge(i[0],i[1]);
        }
        long roads = 0;
        long components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                ArrayList<Integer> tmp = new ArrayList<>();
                g.dfs(i,visited,tmp);
                roads += (long)tmp.size() - 1l;
                components++; 
            }
        }
        return (components * c_lib) + (c_road * roads);
        
    }
    static class Graph {
        int v;
        LinkedList<Integer>[] adjList;
        public Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            for(int i = 0 ; i < v ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int u , int v) {
            adjList[u-1].add(v-1);
            adjList[v-1].add(u-1);
        }
        public void dfs(int i , boolean[] visited, ArrayList<Integer> tmp) {
            if(visited[i]) return;
            visited[i] = true;
            Iterator<Integer> it = adjList[i].iterator();
            while(it.hasNext()) {
                int val = it.next();
                if(!visited[val]) {
                    dfs(val,visited,tmp);
                }
            }
            tmp.add(i);
            return;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
