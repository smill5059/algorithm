import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, L, max;
    static int[][] ingredient;
    static boolean isSelected;
     
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredient = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                ingredient[i][0] = Integer.parseInt(st.nextToken()); //점수
                ingredient[i][1] = Integer.parseInt(st.nextToken()); //칼로리
            }
             
            max = 0;
            choice(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
             
        }
         
        System.out.print(sb.toString());
        in.close();
    }
     
    private static void choice(int cur, int taste, int cal) {
        if (cal > L) return;
        if (cur >= N) {
            max = Math.max(max, taste);
            return;
        }
         
        //선택
        choice(cur+1, taste+ingredient[cur][0], cal+ingredient[cur][1]);
        //비선택
        choice(cur+1, taste, cal);
         
    }
}