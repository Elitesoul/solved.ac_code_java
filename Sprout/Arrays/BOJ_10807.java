//BOJ 10807 개수 세기

import java.io.*;

public class BOJ_10807 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("\\s+");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(array[i]);
        }
        int v = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] == v) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}