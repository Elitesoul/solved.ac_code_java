import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    
    static int n;
    static int answer;
    static char[][] grid1, grid2;
    static boolean[][] visited1, visited2;
    static int[] dfsCount, bfsCount;
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    static String str;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int cy = i + dy[d];
            int cx = j + dx[d];
            if (cy >= 0 && cy < n && cx >= 0 && cx < n && !visited[cy][cx]
                && grid[i][j] == grid[cy][cx]) {
                dfs(visited, grid, cy, cx);
            }
        }
    }
    
    public static void bfs(boolean[][] visited, char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int cy = cur[0] + dy[d];
                int cx = cur[1] + dx[d];
                
                if (cy < 0 || cx < 0 || cy >= n || cx >= n) {
                    continue;
                }
                
                if (!visited[cy][cx] && grid[cy][cx] == grid[i][j]) {
                    visited[cy][cx] = true;
                    queue.add(new int[]{cy, cx});
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        grid1 = new char[n][n];
        grid2 = new char[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        dfsCount = new int[]{0, 0};
        bfsCount = new int[]{0, 0};
        
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < n; j++) {
                char color = str.charAt(j);
                grid1[i][j] = color;
                grid2[i][j] = (color == 'G') ? 'R' : color;
            }
        }
        
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    dfs(visited1, grid1, i, j);
                    dfsCount[0]++;
                }
                if (!visited2[i][j]) {
                    dfs(visited2, grid2, i, j);
                    dfsCount[1]++;
                }
            }
        }
        sb.append(dfsCount[0]).append(" ").append(dfsCount[1]);
        */
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    bfs(visited1, grid1, i, j);
                    bfsCount[0]++;
                }
                if (!visited2[i][j]) {
                    bfs(visited2, grid2, i, j);
                    bfsCount[1]++;
                }
            }
        }
        sb.append(bfsCount[0]).append(" ").append(bfsCount[1]);
        
        System.out.println(sb);
        br.close();
    }
}