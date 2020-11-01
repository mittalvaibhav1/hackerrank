//https://www.hackerrank.com/challenges/bfsshortreach/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static HashMap<Integer,Integer> map;
    static int[] bfs(int n, int m, int[][] edges, int s) {
        map = new HashMap<>();
        Graph g = new Graph(n);
        for(int[] edge : edges) {
            g.addEdge(edge[0],edge[1]);
        }
        boolean[] visited = new boolean[n+1];
        g.bfs(s,visited);
        int[] res = new int[n-1];
        int k = 0;
        for(int i = 1; i <= n ; i++) {
            if(i ==  s ) continue;
            int val = map.getOrDefault(i,-1);
            res[k++] = val == -1 ? -1 : val *6;
        }
        return res;
    }
    static class Graph {
        int v;
        LinkedList<Integer>[] adjList;
        public Graph(int v) {
            this.v = v;
            this.adjList = new LinkedList[v+1];
            for(int i = 1 ; i <= v ; i++) {
                adjList[i] = new LinkedList<>(); 
            }
        }
        public void addEdge(int u , int v) {
            adjList[u].add(v);
            adjList[v].add(u);
        }
        public void bfs(int i,boolean[] visited) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            map.put(i,0);
            while(!q.isEmpty()) {
                int curr = q.poll();
                if(visited[curr]) continue;
                visited[curr] = true;
                Iterator<Integer> it = adjList[curr].iterator();
                while(it.hasNext()) {
                    int neighbour = it.next();
                    if(!visited[neighbour]) {
                        q.add(neighbour);
                        if(!map.containsKey(neighbour))
                        map.put(neighbour,map.get(curr) + 1);
                    }
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
