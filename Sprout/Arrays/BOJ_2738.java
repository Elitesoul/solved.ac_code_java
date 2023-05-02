//BOJ 2738 행렬 덧셈

import java.io.*;

public class BOJ_2738 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);
        int[][] A = new int[x][y];
        int[][] B = new int[x][y];
        for (int i = 0; i < x; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < y; j++) {
                A[i][j] = Integer.parseInt(array[j]);
            }
        }
        for (int i = 0; i < x; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j < y; j++) {
                System.out.printf("%d ", (A[i][j] + Integer.parseInt(array[j])));
            }
            System.out.println();
        }
    }
}