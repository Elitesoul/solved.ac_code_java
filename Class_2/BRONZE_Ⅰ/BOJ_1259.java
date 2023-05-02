import java.io.*;
import java.lang.*;

public class BOJ_1259 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            int i = 0;
            int j = num.length() - 1;
            boolean palindrome = true;
            
            while (i < j) {
                if (num.charAt(i) != num.charAt(j)) {
                    palindrome = false;
                    break;
                }
                i++;
                j--;
            }
            System.out.println(palindrome ? "yes" : "no");
        }
        br.close();
    }
}