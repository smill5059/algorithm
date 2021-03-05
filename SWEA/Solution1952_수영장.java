import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] pay, use;
    static int min;
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            pay = new int[4];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < 4; i++) {
                pay[i] = Integer.parseInt(st.nextToken());
            }
            use = new int[12];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < 12; i++) {
                use[i] = Integer.parseInt(st.nextToken());
            }
             
            min = pay[3];
            findMinDfs(0, 0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
             
        }
         
        System.out.print(sb.toString());
        in.close();
         
    }
     
     
    private static void findMinDfs(int sum, int i) {
        if (sum > min) return;
        if (i > 12) return;
        if (i == 12) {
            if (sum < min) min = sum;
            return;
        }
         
         
 
            if (pay[0]*use[i] < pay[1]) findMinDfs(sum+(pay[0]*use[i]), i+1);
            else findMinDfs(sum+pay[1], i+1);
        findMinDfs(sum+pay[2], i+3);
 
         
    }
     
}