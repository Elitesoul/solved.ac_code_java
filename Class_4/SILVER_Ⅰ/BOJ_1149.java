import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1149 {
    
    static int n;
    static int answer;
    static int[][] rgb;
    static int[] dp;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void solve_2D() throws IOException {
        rgb = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        for (int i = 1; i < n; i++) {
            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
        }
        sb.append(Math.min(Math.min(rgb[n - 1][0], rgb[n - 1][1]), rgb[n - 1][2]));
        
    }
    
    public static void solve_dp() throws IOException {
        dp = new int[3];
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            r = Integer.parseInt(array[0]);
            g = Integer.parseInt(array[1]);
            b = Integer.parseInt(array[2]);
            
            r += Math.min(dp[1], dp[2]);
            g += Math.min(dp[0], dp[2]);
            b += Math.min(dp[0], dp[1]);
            
            dp[0] = r;
            dp[1] = g;
            dp[2] = b;
        }
        sb.append(Math.min(Math.min(dp[0], dp[1]), dp[2]));
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        solve_2D();
        //solve_dp();
        
        System.out.println(sb);
        br.close();
    }
}