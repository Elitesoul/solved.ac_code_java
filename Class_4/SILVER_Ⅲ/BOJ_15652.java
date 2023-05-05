import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_15652 {
    
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
            for (int i = 0; i < m; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = index; i < n; i++) {
            visited[i] = true;
            seq[count] = i + 1;
            dfs(i, count + 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        seq = new int[m];
        visited = new boolean[n];
        
        dfs(0, 0);
        
        System.out.println(sb);
        br.close();
    }
}