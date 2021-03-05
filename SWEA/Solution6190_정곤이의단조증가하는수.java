import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(in.readLine());
            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
             
            int max = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    int n = numbers[i] * numbers[j];
                    if (checkDanjo(n)) max = Math.max(max, n);
                }
            }
             
            sb.append("#").append(tc).append(" ").append(max==0?-1:max).append("\n");
             
        }
         
        System.out.print(sb);
    }
     
    private static boolean checkDanjo(int n) {
        boolean flag = true;
         
        String str = Integer.toString(n);
        int len = str.length();
        int cur = str.charAt(0) - '0';
        for (int i = 1; i < len; i++) {
            int next = str.charAt(i) - '0';
            if (cur > next) {
                flag = false;
                break;
            }
            cur = next;
        }
                 
        return flag;
    }
 
}