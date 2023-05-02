import java.io.*;
import java.lang.*;

public class BOJ_1157 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[] count = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            count[num]++;
        }
        
        int max = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                answer = (char) (i + 'A');
            } else if (max == count[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
        br.close();
    }
}