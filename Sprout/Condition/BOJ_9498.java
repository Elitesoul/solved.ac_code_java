//BOJ 9498 시험 성적

import java.io.*;

public class BOJ_9498 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String scoreString = br.readLine();
        int score = Integer.parseInt(scoreString);
        if (score < 60) {
            System.out.println("F");
        } else if (score < 70) {
            System.out.println("D");
        } else if (score < 80) {
            System.out.println("C");
        } else if (score < 90) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
        
        br.close();
    }
}
