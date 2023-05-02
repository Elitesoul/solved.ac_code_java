//그대로 출력하기

import java.io.*;

public class BOJ_11718 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        
        br.close();
    }
}