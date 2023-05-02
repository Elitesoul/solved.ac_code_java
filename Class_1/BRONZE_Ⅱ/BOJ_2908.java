import java.io.*;
import java.lang.*;

public class BOJ_2908 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split("\\s+");
        for (int i = 0; i < array.length; i++) {
            StringBuffer sb = new StringBuffer(array[i]);
            array[i] = sb.reverse().toString();
        }
        
        System.out
            .println(Integer.parseInt(array[0]) > Integer.parseInt(array[1]) ? array[0] : array[1]);
        
        br.close();
    }
}