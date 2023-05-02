//아스키 코드

import java.io.*;

public class BOJ_11654 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = (int) br.readLine().charAt(0);
        System.out.println(num);
        br.close();
    }
}