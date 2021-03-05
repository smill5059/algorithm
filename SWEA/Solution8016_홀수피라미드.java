import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            long N = Integer.parseInt(in.readLine());
            long left = (N-1)*(N-1)*2 + 1;
            long right = N*N*2 - 1;
             
            sb.append("#").append(tc).append(" ").append(left).append(" ").append(right).append("\n");
             
        }
         
        System.out.print(sb);
         
    }
}