import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_2096 {
    
    static int n;
    static int answer;
    static int[][] min, max;
    
    static Queue<Integer> queue;
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        min = new int[2][3];
        max = new int[2][3];
        
        int a, b, c;
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[1]);
            c = Integer.parseInt(array[2]);
            
            min[1][0] = a + Math.min(min[0][0], min[0][1]);
            min[1][1] = b + Math.min(Math.min(min[0][0], min[0][1]), min[0][2]);
            min[1][2] = c + Math.min(min[0][1], min[0][2]);
            min[0][0] = min[1][0];
            min[0][1] = min[1][1];
            min[0][2] = min[1][2];
            
            max[1][0] = a + Math.max(max[0][0], max[0][1]);
            max[1][1] = b + Math.max(Math.max(max[0][0], max[0][1]), max[0][2]);
            max[1][2] = c + Math.max(max[0][1], max[0][2]);
            max[0][0] = max[1][0];
            max[0][1] = max[1][1];
            max[0][2] = max[1][2];
        }
        
        Arrays.sort(min[1]);
        Arrays.sort(max[1]);
        
        sb.append(max[1][2]).append(" ").append(min[1][0]);
        
        System.out.println(sb);
        br.close();
    }
}