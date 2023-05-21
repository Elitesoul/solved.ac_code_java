import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_11404 {
    
    static int n, m;
    static int answer;
    static long[][] map;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void makeGraph() throws IOException {
        map = new long[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            int c = Integer.parseInt(array[2]);
            
            map[a][b] = Math.min(c, map[a][b]);
        }
    }
    
    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        makeGraph();
        floyd();
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append((map[i][j] != Integer.MAX_VALUE) ? map[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}