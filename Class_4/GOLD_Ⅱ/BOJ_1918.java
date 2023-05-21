import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1918 {
    
    static int n;
    //static int answer;
    static int[][] map;
    
    static String line;
    static Deque<Character> stack;
    static Deque<Character> operators;
    static Deque<String> operands;
    
    static Queue<Integer> queue;
    
    static BufferedReader br;
    static StringBuilder sb;
    
    public static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    
    public static void infixToPostfix() {
        stack = new ArrayDeque<>();
        
        char[] array = line.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
    }
    
    public static String infixToPrefix() {
        operators = new ArrayDeque<>();
        operands = new ArrayDeque<>();
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    String op1 = operands.peek();
                    operands.pop();
                    String op2 = operands.peek();
                    operands.pop();
                    char op = operators.peek();
                    operators.pop();
                    
                    String temp = op + op2 + op1;
                    operands.push(temp);
                }
                operators.pop();
            } else if (Character.isLetterOrDigit(c)) {
                operands.push(c + "");
            } else {
                while (!operators.isEmpty() && priority(c) <= priority(operators.peek())) {
                    String op1 = operands.peek();
                    operands.pop();
                    String op2 = operands.peek();
                    operands.pop();
                    char op = operators.peek();
                    operators.pop();
                    
                    String temp = op + op2 + op1;
                    operands.push(temp);
                }
                operators.push(c);
            }
        }
        
        while (!operators.isEmpty()) {
            String op1 = operands.peek();
            operands.pop();
            String op2 = operands.peek();
            operands.pop();
            char op = operators.peek();
            operators.pop();
            
            String temp = op + op2 + op1;
            operands.push(temp);
        }
        return operands.peek();
    }
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        line = br.readLine();
        
        infixToPostfix();
        
        /*
        String answer = infixToPrefix();
        sb.append(answer);
        */
        
        System.out.println(sb);
        br.close();
    }
}