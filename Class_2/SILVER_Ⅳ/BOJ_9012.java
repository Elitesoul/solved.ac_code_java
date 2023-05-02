import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_9012 {
    
    static String wellMatched(String line) {
        String opening = "(";
        String closing = ")";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (opening.indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                if (opening.indexOf(stack.peek()) != closing.indexOf(ch)) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return (stack.isEmpty()) ? "YES" : "NO";
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            System.out.println(wellMatched(line));
        }
        
        br.close();
    }
}