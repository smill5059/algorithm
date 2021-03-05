import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
             
            int num = Integer.parseInt(in.readLine());
            List[] floor = new List[num+1];
             
            for (int i = 1; i <= num; i++) {
                floor[i] = new ArrayList<Integer>();
                for (int j = 0; j < i; j++) {
                    if (j==0 || j==i-1) floor[i].add(1);
                    else floor[i].add((Integer)floor[i-1].get(j-1) + (Integer)floor[i-1].get(j));
                }
            }
             
            sb.append("#").append(test_case).append("\n");
            for (int i = 1; i <= num; i++) {
                int size = floor[i].size();
                for (int j = 0; j < size; j++) {
                    sb.append(floor[i].get(j)).append(" ");
                }
                sb.append("\n");
            }
             
        }
         
        System.out.println(sb.toString());
    }
}