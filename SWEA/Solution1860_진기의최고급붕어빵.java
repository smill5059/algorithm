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
TC:     for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken()); //손님 수
            int M = Integer.parseInt(st.nextToken()); //M초 동안
            int K = Integer.parseInt(st.nextToken()); //K개의 붕어빵
            int[] customer = new int[N];
             
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                customer[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(customer);
             
            int time = 0, total = 0;
            int i = 0;
            while (i < N) {
                time += M;
                while (customer[i] < time) {
                    total--;
                    i++;
                    if (total < 0) {
                        sb.append("#").append(tc).append(" Impossible\n");
                        continue TC;
                    }
                    if (i >= N) break;
                }
                total += K;
            }
            sb.append("#").append(tc).append(" Possible\n");
             
        }
         
        System.out.print(sb.toString());
    }
}