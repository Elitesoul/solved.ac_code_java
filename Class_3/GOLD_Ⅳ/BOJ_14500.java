import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_14500 {
    
    static int n, m;
    static int answer;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int y, int x, int sum, int count) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int cy = y + dy[i];
            int cx = x + dx[i];
            
            if (cy < 0 || cx < 0 || cy >= n || cx >= m || visited[cy][cx]) {
                continue;
            }
            
            visited[cy][cx] = true;
            dfs(cy, cx, sum + map[cy][cx], count + 1);
            visited[cy][cx] = false;
        }
    }
    
    public static void checkT_1(int y, int x) {
        if (y < n - 2 && x < m - 1) {
            answer = Math.max(answer,
                map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);
        }
        if (y < n - 2 && x > 0) {
            answer = Math.max(answer,
                map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);
        }
        if (y < n - 1 && x < m - 2) {
            answer = Math.max(answer,
                map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
        }
        if (y > 0 && x < m - 2) {
            answer = Math.max(answer,
                map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
        }
    }
    
    public static void checkT_2(int y, int x) {
        int count = 4;
        int min = Integer.MAX_VALUE;
        int sum = map[y][x];
        for (int i = 0; i < 4; i++) {
            int cy = y + dy[i];
            int cx = x + dx[i];
            
            if (count <= 2) {
                return;
            }
            
            if (cy < 0 || cx < 0 || cy >= n || cx >= m || visited[cy][cx]) {
                count--;
                continue;
            }
            min = Math.min(min, map[cy][cx]);
            sum += map[cy][cx];
        }
        
        if (count == 4) {
            sum = sum - min;
        }
        answer = Math.max(answer, sum);
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        
        map = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                checkT_1(i, j);
                //checkT_2(i, j);
            }
        }
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}