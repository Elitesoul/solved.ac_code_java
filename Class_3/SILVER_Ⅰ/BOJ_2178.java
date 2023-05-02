import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2178 {
    
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0}; // up down
    static int[] dCol = {0, 0, -1, 1}; // left right
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new int[]{row, col});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];
                
                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) {
                    continue;
                }
                
                if (visited[nextRow][nextCol] || board[nextRow][nextCol] == 0) {
                    continue;
                }
                
                queue.add(new int[]{nextRow, nextCol});
                board[nextRow][nextCol] = board[curRow][curCol] + 1;
                visited[nextRow][nextCol] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        board = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        bfs(0, 0);
        sb.append(board[n - 1][m - 1]);
        
        System.out.println(sb);
        br.close();
    }
}