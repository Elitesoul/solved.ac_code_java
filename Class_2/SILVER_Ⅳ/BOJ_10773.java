import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10773 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
//        System.out.println(stack);
        
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
        
        br.close();
    }
}