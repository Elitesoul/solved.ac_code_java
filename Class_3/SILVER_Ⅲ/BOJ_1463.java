import java.io.*;
import java.lang.*;

public class BOJ_1463 {
    
    static int n, count;
    static String[] array;
    
    
    static int getOne(int n, int count) {
        if (n < 2) {
            return count;
        }
        return Math.min(getOne(n / 2, count + 1 + (n % 2)), getOne(n / 3, count + 1 + (n % 3)));
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //array = br.readLine().split("\\s+");
        n = Integer.parseInt(br.readLine());
        count = 0;
        System.out.println(getOne(n, count));
        
        br.close();
    }
}