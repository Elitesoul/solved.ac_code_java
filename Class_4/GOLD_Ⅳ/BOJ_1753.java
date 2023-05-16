import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1753 {
    
    static class Node implements Comparable<Node> {
        
        int end, weight;
        
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    
    static int V, E, K;
    static int answer;
    static long[][] graph;
    static ArrayList<ArrayList<Node>> arrayList;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static int choose(long[] dist, boolean[] visited) {
        long min = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void dijkstra1() {
        long[] distance = graph[K].clone();
        boolean[] visited = new boolean[V];
        visited[K] = true;
        
        for (int i = 1; i < V; i++) {
            int u = choose(distance, visited);
            visited[u] = true;
            
            for (int v = 0; v < V; v++) {
                if (!visited[v]) {
                    distance[v] = Math.min(distance[v], distance[u] + graph[u][v]);
                }
            }
        }
        
        for (int i = 0; i < V; i++) {
            if (i == K) {
                sb.append(0).append("\n");
            } else if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
    }
    
    public static void makeGraph() throws IOException {
        graph = new long[V][V];
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < E; i++) {
            array = br.readLine().split("\\s+");
            int u = Integer.parseInt(array[0]) - 1;
            int v = Integer.parseInt(array[1]) - 1;
            int w = Integer.parseInt(array[2]);
            
            graph[u][v] = Math.min(w, graph[u][v]);
        }
    }
    
    public static void dijkstra2() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(K, 0));
        dist[K] = 0;
    
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;
        
            if (!visited[cur]) {
                visited[cur] = true;
            
                for (Node n : arrayList.get(cur)) {
                    if (!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                        dist[n.end] = dist[cur] + n.weight;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
    
        for (int i = 1; i <= V; i++) {
            if (i == K) {
                sb.append(0).append("\n");
            } else if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
    }
    
    public static void makeList() throws IOException {
        arrayList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            arrayList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            array = br.readLine().split("\\s+");
            int u = Integer.parseInt(array[0]);
            int v = Integer.parseInt(array[1]);
            int w = Integer.parseInt(array[2]);
            
            arrayList.get(u).add(new Node(v, w));
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        V = Integer.parseInt(array[0]);
        E = Integer.parseInt(array[1]);
        
        K = Integer.parseInt(br.readLine());
        
        //makeGraph();
        makeList();
        
        //dijkstra1();
        dijkstra2();
        
        System.out.println(sb);
        br.close();
    }
}