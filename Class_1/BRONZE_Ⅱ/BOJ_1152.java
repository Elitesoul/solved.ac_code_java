import java.io.*;
import java.lang.*;

public class BOJ_1152 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.trim();
        if (str.isEmpty()) {
            System.out.println(0);
        } else {
            String[] array = str.split("\\s+");
            System.out.println(array.length);
        }
        br.close();
    }
}