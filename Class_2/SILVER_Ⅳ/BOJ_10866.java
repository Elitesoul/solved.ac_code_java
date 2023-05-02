import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10866 {
    
    static LinkedList<Integer> queue;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] array;
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            array = br.readLine().split("\\s+");
            switch (array[0]) {
                case "push_front":
                    queue.addFirst(Integer.parseInt(array[1]));
                    break;
                case "push_back":
                    queue.addLast(Integer.parseInt(array[1]));
                    break;
                case "pop_front":
                    sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    sb.append(queue.isEmpty() ? -1 : queue.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.getLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}