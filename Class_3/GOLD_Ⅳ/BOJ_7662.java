//https://codeung.tistory.com/315 -> treemap 활용 (현재 코드)
//https://gooweon.tistory.com/115 -> hashmap, priority queue 활용

import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_7662 {
    
    static int t, k, num;
    static int answer;
    static int[][] mat;
    static String str;
    static TreeMap<Integer, Integer> map;
    
    static String[] array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            map = new TreeMap<>();
            k = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < k; i++) {
                array = br.readLine().split("\\s+");
                num = Integer.parseInt(array[1]);
                
                switch (array[0]) {
                    case "I":
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (map.isEmpty()) {
                            break;
                        }
                        if (num == -1) {
                            int min = map.firstKey();
                            if (map.get(min) == 1) {
                                map.remove(min);
                            } else {
                                map.put(min, map.get(min) - 1);
                            }
                        } else {
                            int max = map.lastKey();
                            if (map.get(max) == 1) {
                                map.remove(max);
                            } else {
                                map.put(max, map.get(max) - 1);
                            }
                        }
                        break;
                }
            }
            
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}