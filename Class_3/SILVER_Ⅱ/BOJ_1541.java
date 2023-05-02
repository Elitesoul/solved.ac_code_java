import java.io.*;
import java.lang.*;

public class BOJ_1541 {
    
    static int sum, plusTemp;
    static String[] minusArray, plusArray;
    static BufferedReader br;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        sum = Integer.MAX_VALUE;
        minusArray = br.readLine().split("-");
        
        for (int i = 0; i < minusArray.length; i++) {
            plusTemp = 0;
            plusArray = minusArray[i].split("\\+");
            
            for (int j = 0; j < plusArray.length; j++) {
                plusTemp += Integer.parseInt(plusArray[j]);
            }
            
            if (sum == Integer.MAX_VALUE) {
                sum = plusTemp;
            } else {
                sum -= plusTemp;
            }
        }
        
        System.out.println(sum);
        br.close();
    }
}