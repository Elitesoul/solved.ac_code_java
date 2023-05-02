import java.io.*;

public class BOJ_10809 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.printf("%d ", word.indexOf(i));
        }
        
        br.close();
    }
}