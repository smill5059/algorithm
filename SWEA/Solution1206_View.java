import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    private static int[] buildings;
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= 10; tc++) {
             
            int l = Integer.parseInt(in.readLine());
            buildings = new int[l];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < l; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
             
            int cnt = 0;
            for (int i = 2; i < l-2; i++) {
                cnt += goodView(i);
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
             
        }
         
        System.out.print(sb.toString());
    }
     
    private static int goodView(int cur) {
        int max = 0;
        for (int i = cur-2; i <= cur+2; i++) {
            if (i == cur) continue;
            if (buildings[i] > max) max = buildings[i];
        }
         
        int result = buildings[cur] - max;
        if (result < 0) result = 0;
         
        return result;
    }
}