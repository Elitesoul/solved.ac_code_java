import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_11660 {
    
    static int n, m;
    static int answer;
    static int[][] mat, dp;
    static int startY, startX, endY, endX;
    
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
        
        mat = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 1; j <= n; j++) {
                mat[i][j] = Integer.parseInt(array[j - 1]);
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
                //ex) dp[3][4] = dp[2][4] + dp[3][3] - dp[2][3] + mat[3][4]
            }
        }
        
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            startY = Integer.parseInt(array[0]);
            startX = Integer.parseInt(array[1]);
            endY = Integer.parseInt(array[2]);
            endX = Integer.parseInt(array[3]);
            answer = dp[endY][endX] -
                dp[endY][startX - 1] - dp[startY - 1][endX] + dp[startY - 1][startX - 1];
            //전체배열 - 왼쪽 행 - 위쪽 열 + 겹치는 부분
            //ex) (2, 2) -> (3, 4) : dp[3][4] - dp[3][1] - dp[1][4] + dp[1][1]
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}