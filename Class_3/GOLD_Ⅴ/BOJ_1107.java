import java.io.*;
import java.lang.*;

public class BOJ_1107 {
    
    static int n, m;
    static int answer;
    static boolean[] broken;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        
        if (m != 0) {
            array = br.readLine().split("\\s+");
        }
        
        for (int i = 0; i < m; i++) {
            broken[Integer.parseInt(array[i])] = true;
        }
        
        if (n == 100) {
            answer = 0;
            sb.append(answer);
            System.out.println(sb);
            br.close();
            return;
        }
        
        answer = Math.abs(n - 100);
        int count = 0;
        
        for (int i = 0; i <= 999999; i++) {
            String channel = String.valueOf(i);
            
            boolean check = true;
            for (int j = 0; j < channel.length(); j++) {
                int btn = channel.charAt(j) - '0';
                if (broken[btn]) {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                count = channel.length() + Math.abs(n - i);
                answer = Math.min(answer, count);
            }
        }
        
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}