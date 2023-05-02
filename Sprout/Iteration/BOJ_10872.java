//BOJ 10872 팩토리얼

import java.io.*;

public class BOJ_10872 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        System.out.println(fac);
        br.close();
    }
}