import java.io.*;
import java.lang.*;

public class BOJ_2805 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        
        int[] trees = new int[n];
        array = br.readLine().split("\\s+");
        long max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(array[i]);
            max = Math.max(max, trees[i]);
        }
        
        max++;
        long min = 0;
        long mid;
        long count;
        long temp;
        
        while (min < max) {
            mid = (max + min) / 2;
            count = 0;
            
            for (int i = 0; i < n; i++) {
                temp = trees[i] - mid;
                if (temp > 0) {
                    count += temp;
                }
            }
            
            if (count < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        sb.append(min - 1).append('\n');
        System.out.println(sb);
        
        br.close();
    }
}