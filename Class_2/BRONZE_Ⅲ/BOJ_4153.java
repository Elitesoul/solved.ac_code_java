import java.io.*;
import java.lang.*;

public class BOJ_4153 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] array = br.readLine().split("\\s+");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            int c = Integer.parseInt(array[2]);
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            if (c * c == a * a + b * b) {
                System.out.println("right");
            } else if (a * a == b * b + c * c) {
                System.out.println("right");
            } else if (b * b == a * a + c * c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
        
        br.close();
    }
}