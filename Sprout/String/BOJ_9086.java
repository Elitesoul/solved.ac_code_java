//문자열

import java.io.*;

public class BOJ_9086 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            System.out.printf("%c%c\n", str.charAt(0), str.charAt(str.length() - 1));
        }
        
        br.close();
    }
}