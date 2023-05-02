import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11866 {
    
    static int n, k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        k = Integer.parseInt(array[1]);
        
        LinkedList<Integer> soldiers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            soldiers.add(i);
        }
        
        sb.append('<');
        int index = 0;
        while (n > 1) {
            index = (index + (k - 1)) % n;
            sb.append(soldiers.remove(index)).append(", ");
            n--;
        }
        sb.append(soldiers.remove()).append('>');
        System.out.println(sb);
        
        br.close();
    }
}