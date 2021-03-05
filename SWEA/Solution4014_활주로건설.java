import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, X;
    static int[][] ground, rground;
     
    static int result;
     
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            ground = new int[N][N];
            rground = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    rground[j][i] = ground[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            result = 0;
            process();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
             
        }
                 
        System.out.print(sb.toString());
    }
     
    private static void process() {
        for (int i = 0; i < N; i++) {
            if (construct(ground[i])) result++;
            if (construct(rground[i])) result++;
        }
    }
     
    private static boolean construct(int[] line) {
        int h = line[0];
        int size = 1;
        for (int i = 1; i < N; i++) {
            if (h == line[i]) {
                size++;
            } else if (h+1 == line[i]) {
                if (size < X) return false;
                h++;
                size = 1;
            } else if (h-1 == line[i]) {
                int cnt = 0;
                for (int j = i; j < N; j++) {
                    if (line[j] != h-1) break;
                    cnt++;
                }
                if (cnt < X) return false;
                i += X-1;
                h--;
                size = 0;
            } else {
                return false;
            }
        }
         
        return true;
    }
}