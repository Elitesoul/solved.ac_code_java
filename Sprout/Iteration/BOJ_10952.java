//BOJ 10952 A+B - 5

import java.io.*;

public class BOJ_10952 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] array = br.readLine().split("\\s+");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            if (a == 0 && b == 0) {
                break;
            }
            
            System.out.println(a + b);
        }
        br.close();
    }
}