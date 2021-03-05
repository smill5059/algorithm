import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int N;
    static int[][] synergy;
     
    static boolean[] selected;
    static int min;
     
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int tc = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
             
            N = Integer.parseInt(in.readLine());
            synergy = new int[N][N];
            selected = new boolean[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            min = Integer.MAX_VALUE;
            combination(0, 0);
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(min);
            sb.append("\n");
             
        }
         
        System.out.println(sb.toString());
    }
     
    private static void combination(int start, int cnt) {
        if (cnt == N/2) {
            int aFlavour = flavour(true);
            int bFlavour = flavour(false);
            int diff = Math.abs(aFlavour-bFlavour);
            if (diff < min) min = diff;
            return;
        }
         
        for (int i = start; i < N; i++) {
            selected[i] = true;
            combination(i+1, cnt+1);
            selected[i] = false;
        }
    }
     
    private static int flavour(boolean b) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i] == b) {
                for (int j = 0; j < N; j++) {
                    if (selected[j] == b)
                        sum += synergy[i][j];
                }
            }
        }
        return sum;
    }
}