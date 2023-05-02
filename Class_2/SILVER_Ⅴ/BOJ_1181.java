import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1181 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() > t1.length()) {
                    return 1;
                } else if (s.length() < t1.length()) {
                    return -1;
                } else {
                    return s.compareTo(t1);
                }
            }
        });
        for (String word : list) {
            sb.append(word).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}