import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1874 {
    
    static LinkedList<Integer> stack;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        stack = new LinkedList<>();
        int stackNum = 1;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            while (stack.isEmpty() || stack.peek() < temp) {
                sb.append('+').append('\n');
                stack.push(stackNum++);
            }
            sb.append('-').append('\n');
            stack.pop();
        }
        if (stack.size() > 0) {
            sb = new StringBuilder("NO");
        }
        
        System.out.println(sb);
        br.close();
    }
}