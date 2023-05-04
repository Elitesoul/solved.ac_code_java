import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_5430 {
    
    static int t, n;
    static int count;
    static Deque<Integer> deque;
    static boolean reverse, error;
    
    static String str;
    static String[] p, array;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            p = br.readLine().split("");
            n = Integer.parseInt(br.readLine());
            
            str = br.readLine();
            array = str.substring(1, str.length() - 1).split(",");
            deque = new LinkedList<>();
            
            if (n != 0) {
                for (String value : array) {
                    deque.add(Integer.parseInt(value));
                }
            }
            
            reverse = false;
            error = false;
            
            for (String s : p) {
                switch (s) {
                    case "R":
                        reverse = !reverse;
                        break;
                    case "D":
                        if (deque.size() == 0) {
                            error = true;
                            break;
                        }
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                        break;
                }
            }
            
            if (error) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (deque.size() > 1) {
                    if (reverse) {
                        sb.append(deque.pollLast()).append(",");
                    } else {
                        sb.append(deque.pollFirst()).append(",");
                    }
                }
                if (deque.size() != 0) {
                    sb.append(deque.getFirst());
                }
                sb.append("]").append("\n");
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}