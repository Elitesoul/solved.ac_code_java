import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11723 {
    
    static int m;
    static String[] array;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            array = br.readLine().split("\\s+");
            switch (array[0]) {
                case "add":
                    set.add(array[1]);
                    break;
                case "remove":
                    set.remove(array[1]);
                    break;
                case "check":
                    sb.append(set.contains(array[1]) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    if (set.contains(array[1])) {
                        set.remove(array[1]);
                    } else {
                        set.add(array[1]);
                    }
                    break;
                case "all":
                    set = new HashSet<>();
                    for (int j = 1; j <= 20; j++) {
                        set.add(Integer.toString(j));
                    }
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}