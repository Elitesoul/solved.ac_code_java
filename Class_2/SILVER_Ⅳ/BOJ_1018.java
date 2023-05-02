import java.io.*;
import java.lang.*;

public class BOJ_1018 {
    
    public static boolean[][] chess;
    public static int min = 64;
    
    public static void count(int x, int y) {
        int xEnd = x + 8;
        int yEnd = y + 8;
        int count = 0;
        boolean first = chess[x][y];
        
        for (int i = x; i < xEnd; i++) {
            for (int j = y; j < yEnd; j++) {
                if (chess[i][j] != first) {
                    count++;
                }
                first = !first;
            }
            first = !first;
        }
        
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] array = br.readLine().split("\\s+");
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);
        chess = new boolean[x][y];
        
        for (int i = 0; i < x; i++) {
            String line = br.readLine();
            for (int j = 0; j < y; j++) {
                chess[i][j] = (line.charAt(j) == 'W');
            }
        }
        
        for (int i = 0; i < x - 7; i++) {
            for (int j = 0; j < y - 7; j++) {
                count(i, j);
            }
        }
        System.out.println(min);
        br.close();
    }
}