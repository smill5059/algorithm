import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int tc = Integer.parseInt(in.readLine());
        for (int test_case = 0; test_case < tc; test_case++) {
            int num = Integer.parseInt(in.readLine());
            int[] score = new int[101];
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < 1000; i++) {
                int temp = Integer.parseInt(st.nextToken());
                ++score[temp];
            }
             
            int max = 0, idx = 0;
            for (int i = 1; i <= 100; i++) {
                if (score[i] >= max) {
                    max = score[i];
                    idx = i;
                }
            }
             
            sb.append("#");
            sb.append(num);
            sb.append(" ");
            sb.append(idx);
            sb.append("\n");
        }
         
        System.out.println(sb.toString());
    }
}