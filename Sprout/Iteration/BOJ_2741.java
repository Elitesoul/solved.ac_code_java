//BOJ 2741 N 찍기

import java.io.*;

public class BOJ_2741 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
        br.close();
    }
}