import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(in.readLine()); //옷의 벌 수
            int[] price = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
             
            Arrays.sort(price);
            int sum = 0, idx = 0;
            for (int i = N-1; i >= 0; i--) {
                idx++;
                if (idx%3 == 0) continue;
                sum += price[i];
            }
             
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
             
        }
         
        System.out.print(sb);
    }
}