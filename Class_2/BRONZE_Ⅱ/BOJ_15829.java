import java.io.*;
import java.math.BigInteger;
import java.lang.*;

public class BOJ_15829 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int l = Integer.parseInt(br.readLine());
        int r = 31;
        BigInteger m = BigInteger.valueOf(1234567891);
        String[] array = br.readLine().split("");
        BigInteger result = new BigInteger(String.valueOf(BigInteger.ZERO));
        for (int i = 0; i < l; i++) {
            long alphabet = array[i].charAt(0) - 'a' + 1;
            BigInteger h = BigInteger.valueOf(31);
            h = h.pow(i);
            h = h.multiply(BigInteger.valueOf(alphabet));
            result = result.add(h);
        }
        System.out.println(result.remainder(m));
        br.close();
    }
}