import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
                         
            int answer = (D-11)*1440 + (H-11)*60 + (M-11);
            sb.append("#").append(tc).append(" ").append(answer<0?-1:answer).append("\n");
             
        }
         
        System.out.print(sb);
         
    }
}