import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_3052 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            set.add(n % 42);
        }
        System.out.println(set.size());
        br.close();
    }
}