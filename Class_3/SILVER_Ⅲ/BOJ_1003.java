import java.io.*;
import java.lang.*;

public class BOJ_1003 {
    
    static int t, n;
    static String[] array;
    static int zeroCount, oneCount, allCount;
    
    static void fibonacci(int n) {
        zeroCount = 1;
        oneCount = 0;
        allCount = 1;
        for (int i = 0; i < n; i++) {
            zeroCount = oneCount;
            oneCount = allCount;
            allCount = zeroCount + oneCount;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //array = br.readLine().split("\\s+");
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(zeroCount).append(' ').append(oneCount).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}