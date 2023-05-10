import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1932 {
    
    static int n;
    static int answer;
    static int[][] mat;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        mat = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            for (int j = 0; j <= i; j++) {
                mat[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                mat[i - 1][j] += Math.max(mat[i][j], mat[i][j + 1]);
            }
        }
        
        sb.append(mat[0][0]);
        System.out.println(sb);
        br.close();
    }
}