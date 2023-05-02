import java.io.*;
import java.lang.*;

public class BOJ_2630 {
    
    static int n, white, blue;
    static String[] array;
    static int[][] board;
    
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
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        
        int newSize = size / 2;
        
        divide(row, col, newSize); //2사분면
        divide(row, col + newSize, newSize); //1사분면
        divide(row + newSize, col, newSize); //3사분면
        divide(row + newSize, col + newSize, newSize); //4사분면
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(array[j]);
            }
        }
        white = 0;
        blue = 0;
        
        divide(0, 0, n);
        
        sb.append(white).append('\n');
        sb.append(blue).append('\n');
        System.out.println(sb);
        br.close();
    }
}