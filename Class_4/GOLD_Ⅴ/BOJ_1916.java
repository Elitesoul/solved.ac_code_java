import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1916 {
    
    static class Town implements Comparable<Town> {
        
        int end, cost;
        
        public Town(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Town o) {
            return cost - o.cost;
        }
    }
    
    static int n, m;
    static int answer;
    static long[][] graph;
    static int source, dest;
    static ArrayList<List<Town>> arrayList;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static int choose(long[] dist, boolean[] visited) {
        long min = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void dijkstra1() {
        
        long[] distance = graph[source].clone();
        boolean[] visited = new boolean[n];
        visited[source] = true;
        
        for (int i = 1; i < n; i++) {
            int u = choose(distance, visited);
            visited[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    distance[v] = Math.min(distance[v], distance[u] + graph[u][v]);
                }
            }
        }
        
        sb.append(distance[dest]).append("\n");
    }
    
    public static void makeGraph() throws IOException {
        graph = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            int u = Integer.parseInt(array[0]) - 1;
            int v = Integer.parseInt(array[1]) - 1;
            int w = Integer.parseInt(array[2]);
            
            graph[u][v] = Math.min(w, graph[u][v]);
        }
        
        array = br.readLine().split("\\s+");
        source = Integer.parseInt(array[0]) - 1;
        dest = Integer.parseInt(array[1]) - 1;
    }
    
    public static void dijkstra2() {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Town(source, 0));
        dist[source] = 0;
        
        while (!pq.isEmpty()) {
            Town curTown = pq.poll();
            int cur = curTown.end;
            
            if (!visited[cur]) {
                visited[cur] = true;
                
                for (Town t : arrayList.get(cur)) {
                    if (!visited[t.end] && dist[t.end] > dist[cur] + t.cost) {
                        dist[t.end] = dist[cur] + t.cost;
                        pq.add(new Town(t.end, dist[t.end]));
                    }
                }
            }
        }
        sb.append(dist[dest]).append("\n");
    }
    
    public static void makeList() throws IOException {
        arrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            int u = Integer.parseInt(array[0]);
            int v = Integer.parseInt(array[1]);
            int cost = Integer.parseInt(array[2]);
            
            arrayList.get(u).add(new Town(v, cost));
        }
        
        array = br.readLine().split("\\s+");
        source = Integer.parseInt(array[0]);
        dest = Integer.parseInt(array[1]);
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        makeGraph();
        //makeList();
        
        dijkstra1();
        //dijkstra2();
        
        System.out.println(sb);
        br.close();
    }
}