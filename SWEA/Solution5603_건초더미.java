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
            int[] hay = new int[N];
            for (int i = 0; i < N; i++) {
                hay[i] = Integer.parseInt(in.readLine());
            }
             
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += hay[i];
            }
            int avg = sum / N;
             
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (hay[i] < avg) result += (avg - hay[i]);
            }
             
            sb.append("#").append(tc).append(" ").append(result).append("\n");
             
        }
         
        System.out.println(sb);
    }
}