//단어 길이 재기

import java.io.*;

public class BOJ_2743 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        System.out.println(word.length());
        br.close();
    }
}