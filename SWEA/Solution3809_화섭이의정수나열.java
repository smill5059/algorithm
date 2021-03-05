import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
     
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(in.readLine());
            StringBuilder sb = new StringBuilder();
            int tmp = 0;
            do {
                String str = in.readLine().replaceAll("\\s", "");
                tmp += str.length();
                sb.append(str);
            } while(tmp < N);
             
            for (int i = 0; i <= 1000; i++) {
                if (!sb.toString().contains(Integer.toString(i))) {
                    System.out.println("#" + tc + " " + i);
                    break;
                }
            }
             
        }
         
    }
}