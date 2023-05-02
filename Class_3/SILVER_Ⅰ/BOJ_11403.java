import java.io.*;
import java.lang.*;

public class BOJ_11403 {
    
    static int n;
    static int answer;
    static int[][] mat;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        mat = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            array = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(array[j]);
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][k] == 1 && mat[k][j] == 1) {
                        mat[i][j] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
}