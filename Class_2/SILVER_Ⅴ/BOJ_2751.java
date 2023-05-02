import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2751 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        for (int num : list) {
            sb.append(num).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}