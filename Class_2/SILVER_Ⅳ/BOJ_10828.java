import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10828 {
    
    static Stack<Integer> stack;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] array;
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            switch (array[0]) {
                case "push":
                    stack.push(Integer.parseInt(array[1]));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.lastElement()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}