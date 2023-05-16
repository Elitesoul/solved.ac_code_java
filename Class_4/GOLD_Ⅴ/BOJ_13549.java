import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_13549 {
    
    static class Loc implements Comparable<Loc> {
        
        int now;
        int time;
        
        public Loc(int now, int time) {
            this.now = now;
            this.time = time;
        }
        
        
        @Override
        public int compareTo(Loc o) {
            return time - o.time;
        }
        
    }
    
    static int n, k;
    static int answer;
    static int[][] mat;
    
    static Deque<Loc> dq;
    static PriorityQueue<Loc> pq;
    static boolean[] visited;
    static int[] dist;
    static int MAX = 100001;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dijkstra() {
        pq = new PriorityQueue<>();
        dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.offer(new Loc(n, 0));
        dist[n] = 0;
        
        while (!pq.isEmpty()) {
            Loc loc = pq.poll();
            
            if (dist[loc.now] < loc.time) {
                continue;
            }
            
            int[] next = new int[]{
                loc.now * 2,
                loc.now + 1,
                loc.now - 1
            };
            
            for (int i = 0; i < next.length; i++) {
                if (next[i] < 0 || next[i] > MAX - 1) {
                    continue;
                }
                
                int move = (i == 0) ? 0 : 1;
                
                if (dist[next[i]] > loc.time + move) {
                    dist[next[i]] = loc.time + move;
                    pq.offer(new Loc(next[i], dist[next[i]]));
                }
            }
        }
        answer = dist[k];
    }
    
    public static void bfs() {
        dq = new LinkedList<>();
        dq.offer(new Loc(n, 0));
        
        visited = new boolean[MAX];
        visited[n] = true;
        
        while (!dq.isEmpty()) {
            Loc loc = dq.poll();
            
            if (loc.now == k) {
                answer = loc.time;
                return;
            }
            
            int[] next = new int[]{
                loc.now * 2,
                loc.now + 1,
                loc.now - 1
            };
            
            for (int i = 0; i < next.length; i++) {
                if (next[i] >= 0 && next[i] <= MAX - 1 && !visited[next[i]]) {
                    if (i == 0) {
                        dq.addFirst(new Loc(next[i], loc.time));
                        visited[next[i]] = true;
                    } else {
                        dq.addLast(new Loc(next[i], loc.time + 1));
                        visited[next[i]] = true;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        k = Integer.parseInt(array[1]);
        
        //bfs();
        dijkstra();
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}