import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int tc = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
             
            int days = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int[] price = new int[days];
            for (int i = 0; i < days; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
             
            int max = 0;
            long sum = 0;
            for (int i = days-1; i >= 0; i--) {
                if (price[i] > max) {
                    max = price[i];
                } else {
                    int profit = max - price[i];
                    sum += profit;
                }
            }
             
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(sum);
            sb.append("\n");
             
        }
         
        System.out.println(sb.toString());
    }
}