import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_15657 {
    
    static int n, m;
    static int answer;
    static int[][] mat;
    
    static int[] seq, print;
    static boolean[] visited;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int index, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(print[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = index; i < n; i++) {
            visited[i] = true;
            print[count] = seq[i];
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
        
        seq = new int[n];
        print = new int[n];
        visited = new boolean[n];
        
        array = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(seq);
        dfs(0, 0);
        
        System.out.println(sb);
        br.close();
    }
}