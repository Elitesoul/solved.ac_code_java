import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1546 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("\\s+");
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(array[i]));
        }
        
        list.sort(Comparator.reverseOrder());
        int max = list.get(0);
        double sum = 0;
        for (int score : list) {
            sum += ((double) score / (double) max) * 100;
        }
        double average = sum / (double) n;
        System.out.println(average);
        br.close();
    }
}