import java.io.*;
import java.lang.*;

public class BOJ_1654 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] array = br.readLine().split("\\s+");
        int k = Integer.parseInt(array[0]);
        int n = Integer.parseInt(array[1]);
        
        int[] lines = new int[n];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }
        
        max++;
        long min = 0;
        long mid;
        long count;
        
        while (min < max) {
            mid = (max + min) / 2;
            
            count = 0;
            for (int i = 0; i < k; i++) {
                count += (lines[i] / mid);
            }
            
            if (count < n) {
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