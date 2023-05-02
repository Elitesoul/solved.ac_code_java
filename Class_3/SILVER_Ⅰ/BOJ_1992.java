import java.io.*;
import java.lang.*;

public class BOJ_1992 {
    
    static int n;
    static int[][] board;
    static String[] array;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static boolean checkColor(int row, int col, int size) {
        int color = board[row][col];
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void divide(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }
        
        int newSize = size / 2;
        
        sb.append('(');
        
        divide(row, col, newSize); // 2 quadrant
        divide(row, col + newSize, newSize); // 1 quadrant
        divide(row + newSize, col, newSize); // 3 quadrant
        divide(row + newSize, col + newSize, newSize); // 4 quadrant
        
        sb.append(')');
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        divide(0, 0, n); // row, col, size
        
        System.out.println(sb);
        br.close();
    }
}