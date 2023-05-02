//BOJ 15552 빠른 A+B

import java.io.*;

public class BOJ_15552 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("\\s+");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            bw.write((a + b) + "\n");
        }
        br.close();
        bw.close();
    }
}