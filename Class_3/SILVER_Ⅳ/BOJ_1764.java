import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1764 {
    
    static int n, m;
    static String[] array;
    static Set<String> notHeard;
    static String notSeen;
    static List<String> both;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        array = br.readLine().split("\\s+");
        n = Integer.parseInt(array[0]);
        m = Integer.parseInt(array[1]);
        notHeard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notHeard.add(br.readLine());
        }
        
        both = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            notSeen = br.readLine();
            if (notHeard.contains(notSeen)) {
                both.add(notSeen);
            }
        }
        Collections.sort(both);
        sb.append(both.size()).append('\n');
        for (String name : both) {
            sb.append(name).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}