import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16928 {
    
    static int n, m;
    static int answer;
    static int[][] board;
    static int[] move, count;
    static boolean[] visited;
    static Queue<Integer> queue;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        move = new int[101];
        count = new int[101];
        visited = new boolean[101];
        queue = new LinkedList<>();
        
        for (int i = 0; i < n + m; i++) {
            array = br.readLine().split("\\s+");
            int u = Integer.parseInt(array[0]);
            int v = Integer.parseInt(array[1]);
            move[u] = v;
        }
        
        queue.add(1);
        count[1] = 0;
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (cur == 100) {
                sb.append(count[cur]);
                break;
            }
            
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                
                if (next > 100 || visited[next]) {
                    continue;
                }
                
                if (move[next] != 0) {
                    if (!visited[move[next]]) {
                        visited[move[next]] = true;
                        count[move[next]] = count[cur] + 1;
                        queue.add(move[next]);
                    }
                } else {
                    visited[next] = true;
                    count[next] = count[cur] + 1;
                    queue.add(next);
                }
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}