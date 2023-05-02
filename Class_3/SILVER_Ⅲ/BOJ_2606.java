import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2606 {
    
    static int n, m;
    static String[] array;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static int dfsAnswer = 0;
    static int bfsAnswer = 0;
    
    static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        dfsAnswer++;
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
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : nodes[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    bfsAnswer++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //array = br.readLine().split("\\s+");
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
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
        
        dfs(1);
        System.out.println(dfsAnswer - 1);

//        Arrays.fill(visited, false);
//        bfs(1);
//        System.out.println(bfsAnswer);
        
        br.close();
    }
}