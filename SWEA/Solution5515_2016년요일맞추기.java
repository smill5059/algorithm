import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] week = {3, 4, 5, 6, 0, 1, 2};
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
             
            int temp = 0;
            for (int i = 1; i < m; i++) {
                temp += month[i];
            }
            temp += d;
            int dayOfWeek = week[temp%7];
             
            sb.append("#").append(tc).append(" ").append(dayOfWeek).append("\n");
             
        }
         
        System.out.print(sb.toString());
    }
}