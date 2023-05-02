//문자와 문자열

import java.io.*;
import java.lang.*;

public class BOJ_27866 {
    
    static int n;
    static int answer;
    static int[][] mat;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        sb.append(br.readLine().charAt(Integer.parseInt(br.readLine()) - 1));
        
        System.out.println(sb);
        br.close();
    }
}