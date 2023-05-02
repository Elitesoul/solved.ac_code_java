import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_4949 {
    
    static String wellMatched(String line) {
        String opening = "([";
        String closing = ")]";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (opening.indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "no";
                }
                if (opening.indexOf(stack.peek()) != closing.indexOf(ch)) {
                    return "no";
                }
                stack.pop();
            }
        }
        return (stack.isEmpty()) ? "yes" : "no";
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            } else {
                line = line.trim();
                line = line.replaceAll("\\.", "");
                line = line.replaceAll("\\w", "");
                line = line.replaceAll(" ", "");
//                System.out.println(line);
                System.out.println(wellMatched(line));
            }
        }
        
        br.close();
    }
}