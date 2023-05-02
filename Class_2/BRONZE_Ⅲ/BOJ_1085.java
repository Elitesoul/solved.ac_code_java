import java.io.*;
import java.lang.*;

public class BOJ_1085 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split(" ");
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);
        int w = Integer.parseInt(array[2]);
        int h = Integer.parseInt(array[3]);
        
        int minWidth = Math.min(x, w - x);
        int minHeight = Math.min(y, h - y);
        
        System.out.println(Math.min(minWidth, minHeight));
        
        br.close();
    }
}