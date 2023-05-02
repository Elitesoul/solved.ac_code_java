//BOJ 10951 A+B - 4

import java.io.*;

public class BOJ_10951 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            String[] array = str.split("\\s+");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            System.out.println(a + b);
        }
        
        br.close();
    }
}