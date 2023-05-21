import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1865 {
    
    static class Node {
        
        int end;
        int time;
        
        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
    
    static int t, n, m, w;
    static int answer;
    static int[][] map;
    
    static ArrayList<ArrayList<Node>> arrayList;
    static long[] dist;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static boolean bellman() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        boolean update = false;
        
        for (int i = 1; i < n; i++) {
            update = false;
            
            for (int j = 1; j <= n; j++) {
                for (Node node : arrayList.get(j)) {
                    if (dist[node.end] > dist[j] + node.time) {
                        dist[node.end] = dist[j] + node.time;
                        update = true;
                    }
                }
            }
            
            if (!update) {
                break;
            }
        }
        
        /*
        if (update) {
            for (int i = 1; i <= n; i++) {
                for (Node node : arrayList.get(i)) {
                    if (dist[node.end] > dist[i] + node.time) {
                        return true;
                    }
                }
            }
        }
        */
        
        return update;
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            array = br.readLine().split("\\s+");
            n = Integer.parseInt(array[0]);
            m = Integer.parseInt(array[1]);
            w = Integer.parseInt(array[2]);
            
            dist = new long[n + 1];
            arrayList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                arrayList.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m + w; i++) {
                array = br.readLine().split("\\s+");
                int s = Integer.parseInt(array[0]);
                int e = Integer.parseInt(array[1]);
                int t = Integer.parseInt(array[2]);
                
                if (i < m) {
                    arrayList.get(s).add(new Node(e, t));
                    arrayList.get(e).add(new Node(s, t));
                } else {
                    arrayList.get(s).add(new Node(e, t * -1));
                }
            }
            
            sb.append(bellman() ? "YES" : "NO").append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}