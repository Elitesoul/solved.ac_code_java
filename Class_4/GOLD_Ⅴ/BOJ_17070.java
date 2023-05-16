import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_17070 {
    
    static int n;
    static int answer;
    static int[][] map;
    static int[][][] dp;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dp1() {
        dp = new int[n][n][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (map[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; //가로
                    if (i >= 1) {
                        dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]; //세로
                        if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                            dp[i][j][2] = //대각
                                dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                        }
                    }
                }
            }
        }
        answer = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
    }
    
    public static void dfs(int x, int y, int direction) { // 0 : 가로 , 1 : 세로, 2 : 대각
        if (x == n - 1 && y == n - 1) {
            answer++;
            return;
        }
        
        if (direction == 0 || direction == 2) {
            if (y + 1 < n && map[x][y + 1] == 0) {
                dfs(x, y + 1, 0); //가로
            }
        }
        
        if (direction == 1 || direction == 2) {
            if (x + 1 < n && map[x + 1][y] == 0) {
                dfs(x + 1, y, 1); // 세로
            }
        }
        
        if (x + 1 < n && y + 1 < n && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0
            && map[x][y + 1] == 0) {
            dfs(x + 1, y + 1, 2); // 대각
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        //dp1();
        
        answer = 0;
        dfs(0, 1, 0);
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}