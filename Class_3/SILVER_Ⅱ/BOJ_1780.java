import java.io.*;
import java.lang.*;

public class BOJ_1780 {
    
    static int n;
    static String[] array;
    static int[][] board;
    static int minusOneCount, zeroCount, oneCount;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    static boolean checkNum(int row, int col, int size) {
        int num = board[row][col];
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != board[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static void divide(int row, int col, int size) {
        if (checkNum(row, col, size)) {
            if (board[row][col] == -1) {
                minusOneCount++;
            } else if (board[row][col] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }
        int newSize = size / 3;
        
        divide(row, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row, col + 2 * newSize, newSize);
        
        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
        divide(row + newSize, col + 2 * newSize, newSize);
        
        divide(row + 2 * newSize, col, newSize);
        divide(row + 2 * newSize, col + newSize, newSize);
        divide(row + 2 * newSize, col + 2 * newSize, newSize);
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
        
        divide(0, 0, n);
        sb.append(minusOneCount).append('\n');
        sb.append(zeroCount).append('\n');
        sb.append(oneCount).append('\n');
        
        System.out.println(sb);
        br.close();
    }
}