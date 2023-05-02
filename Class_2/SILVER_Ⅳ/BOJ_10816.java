import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10816 {
    
    static List<Integer> list;
    
    public static int lowIndex(int target) {
        
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public static int highIndex(int target) {
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("\\s+");
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(array[i]));
        }
        Collections.sort(list);
//        System.out.println(list);
        
        int m = Integer.parseInt(br.readLine());
        array = br.readLine().split("\\s+");
        int start, end;
        for (int i = 0; i < m; i++) {
            start = lowIndex(Integer.parseInt(array[i]));
            end = highIndex(Integer.parseInt(array[i]));
            sb.append(end - start).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}