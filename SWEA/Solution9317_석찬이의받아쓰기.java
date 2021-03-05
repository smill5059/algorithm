import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            String given = in.readLine();
            String seok = in.readLine();
             
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (given.charAt(i) == seok.charAt(i)) cnt++;
            }
             
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
         
        System.out.print(sb);
    }
}