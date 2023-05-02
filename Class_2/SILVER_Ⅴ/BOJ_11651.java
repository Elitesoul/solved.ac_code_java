import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11651 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("\\s+");
            points[i][0] = Integer.parseInt(array[0]);
            points[i][1] = Integer.parseInt(array[1]);
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[1] == p2[1]) {
                    return p1[0] - p2[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });
        
        for (int i = 0; i < n; i++) {
            sb.append(points[i][0]).append(' ').append(points[i][1]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}