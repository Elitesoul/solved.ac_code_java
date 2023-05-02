import java.io.*;
import java.lang.*;

public class BOJ_7568 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("\\s+");
            weight[i] = Integer.parseInt(array[0]);
            height[i] = Integer.parseInt(array[1]);
        }
        int rank;
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            rank = 1;
            for (int j = 0; j < n; j++) {
                if (weight[j] > weight[i] && height[j] > height[i]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        
        for (int num : ranks) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
        br.close();
    }
}