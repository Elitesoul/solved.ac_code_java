import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2667 {
    
    static int n, count;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Integer> counts;
    static int[] dRow = {-1, 1, 0, 0}; // up down
    static int[] dCol = {0, 0, -1, 1}; // left right
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void dfs(int row, int col) {
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
                continue;
            }
            if (visited[nextRow][nextCol] || board[nextRow][nextCol] == 0) {
                continue;
            }
            
            count++;
            dfs(nextRow, nextCol);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        counts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    counts.add(count);
                }
            }
        }
        
        sb.append(counts.size()).append('\n');
        Collections.sort(counts);
        for (Integer num : counts) {
            sb.append(num).append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
}