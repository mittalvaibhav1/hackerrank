//https://www.hackerrank.com/challenges/journey-to-the-moon/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {
        long ans = (((long)n) * (n-1))/2l;
        Graph g = new Graph(n);
        for(int i = 0 ; i < astronaut.length ; i++) {
            g.addEdge(astronaut[i][0],astronaut[i][1]);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ;i++) {
            if(!visited[i]) {
                ArrayList<Integer> tmp = new ArrayList<>();
                g.dfs(i,visited,tmp);
                ans -= (((long)tmp.size()) * (tmp.size()-1))/2l;
            }
        }
        return ans;
    }
    static class Graph {
        int v;
        LinkedList<Integer> adjList[];
        public Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            for(int i = 0 ; i < v ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int u , int v) {
            adjList[u].add(v);
            adjList[v].add(u);
        } 
        public void dfs(int i, boolean[] visited , ArrayList<Integer> tmp) {
            if(visited[i]) return;
            visited[i] = true;
            Iterator<Integer> it = adjList[i].iterator();
            while(it.hasNext()) {
                int node = it.next();
                if(!visited[node]) {
                    dfs(node,visited,tmp);
                }
            }
            tmp.add(i);
            return;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {
        long ans = 0;
        long sum = 0;
        Graph g = new Graph(n);
        for(int i = 0 ; i < astronaut.length ; i++) {
            g.addEdge(astronaut[i][0],astronaut[i][1]);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ;i++) {
            if(!visited[i]) {
                ArrayList<Integer> tmp = new ArrayList<>();
                g.dfs(i,visited,tmp);
                ans += sum *tmp.size();
                sum += tmp.size();
            }
        }
        return ans;
    }
    static class Graph {
        int v;
        LinkedList<Integer> adjList[];
        public Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            for(int i = 0 ; i < v ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int u , int v) {
            adjList[u].add(v);
            adjList[v].add(u);
        } 
        public void dfs(int i, boolean[] visited , ArrayList<Integer> tmp) {
            if(visited[i]) return;
            visited[i] = true;
            Iterator<Integer> it = adjList[i].iterator();
            while(it.hasNext()) {
                int node = it.next();
                if(!visited[node]) {
                    dfs(node,visited,tmp);
                }
            }
            tmp.add(i);
            return;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

*/