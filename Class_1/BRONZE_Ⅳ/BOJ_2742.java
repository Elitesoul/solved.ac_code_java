import java.io.*;
import java.lang.*;

public class BOJ_2742 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }
        
        br.close();
    }
}