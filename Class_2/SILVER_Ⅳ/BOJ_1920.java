import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1920 {
    
    public static int n, m;
    public static int[] a;
    
    static boolean find(int num) {
        int start, mid, end;
        start = 0;
        end = n - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            int val = a[mid];
            if (num == val) {
                return true;
            }
            if (num > val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        String[] array = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(a);
        
        m = Integer.parseInt(br.readLine());
        array = br.readLine().split("\\s+");
        for (int i = 0; i < m; i++) {
            sb.append(find(Integer.parseInt(array[i])) ? 1 : 0).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}