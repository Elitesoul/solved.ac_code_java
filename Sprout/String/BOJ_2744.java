//대소문자 바꾸기

import java.io.*;

public class BOJ_2744 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] array = new char[word.length()];
        
        for (int i = 0; i < array.length; i++) {
            char temp = word.charAt(i);
            if (Character.isUpperCase(temp)) {
                array[i] = Character.toLowerCase(temp);
            } else {
                array[i] = Character.toUpperCase(temp);
            }
        }
        
        String changed = String.valueOf(array);
        System.out.println(changed);
        
        br.close();
    }
}