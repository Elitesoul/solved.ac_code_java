import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_15650 {
    
    static int n, m;
    static int answer;
    static int[][] mat;
    
    static int[] seq;
    static boolean[] visited;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int index, int count) {
        if (count == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(seq[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        seq = new int[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }
        
        dfs(0, 0);
        
        System.out.println(sb);
        br.close();
    }
}