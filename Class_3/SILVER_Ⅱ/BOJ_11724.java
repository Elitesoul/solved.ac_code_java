import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11724 {
    
    static int n, m, u, v;
    static int dfsCount, bfsCount;
    static String[] array;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : adjList[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
    
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && adjList[current].contains(i)) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            u = Integer.parseInt(array[0]);
            v = Integer.parseInt(array[1]);
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                //dfs(i);
                //dfsCount++;
                
                bfs(i);
                bfsCount++;
            }
        }
        
        //System.out.println(dfsCount);
        System.out.println(bfsCount);
        br.close();
    }
}