import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
             
            int theta = Integer.parseInt(in.readLine());
            int minute = (theta*2) % 60;
            int hour = ((theta*2) / 60) % 12;
             
            sb.append("#").append(test_case).append(" ").append(hour).append(" ").append(minute).append("\n");
             
        }
         
        System.out.print(sb.toString());
    }
}