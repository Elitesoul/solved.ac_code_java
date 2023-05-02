import java.io.*;
import java.lang.*;

public class BOJ_9461 {
    
    static int t, n;
    static String[] array;
    static long[] dp;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        array = br.readLine().split("\\s+");
        t = Integer.parseInt(br.readLine());
        
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
        
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}