import java.io.*;
import java.lang.*;

public class BOJ_17626 {
    
    static int n, min;
    static String[] array;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        array = br.readLine().split("\\s+");
        n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(1);
        } else {
            dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, dp[i - j * j]);
                }
                dp[i] = min + 1;
            }
            
            System.out.println(dp[n]);
        }
        
        br.close();
    }
}