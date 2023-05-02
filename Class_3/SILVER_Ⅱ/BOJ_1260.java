import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1260 {
    
    static int n, m, k;
    static String[] array;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static StringBuilder sb;
    
    static void dfs(int node) {
        sb.append(node).append(' ');
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int next : nodes[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        sb.append(node).append(' ');
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : nodes[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    sb.append(next).append(' ');
                    q.add(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        k = Integer.parseInt(array[2]);
        
        visited = new boolean[n + 1];
        nodes = new ArrayList[n + 1];
        Arrays.fill(visited, false);
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            int v = Integer.parseInt(array[0]);
            int u = Integer.parseInt(array[1]);
            nodes[v].add(u);
            nodes[u].add(v);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(nodes[i]);
        }
        
        dfs(k);
        sb.append('\n');
        
        Arrays.fill(visited, false);
        bfs(k);
        sb.append('\n');
        
        System.out.println(sb);
        br.close();
    }
}