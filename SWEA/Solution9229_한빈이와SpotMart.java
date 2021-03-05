import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    private static int N, M;
    private static int[] input;
    private static int max = -1;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = in.readLine();
            st = new StringTokenizer(str);
 
            N = Integer.parseInt(st.nextToken());
            input = new int[N];
            M = Integer.parseInt(st.nextToken());
 
            str = in.readLine();
            st = new StringTokenizer(str);
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
 
            combination(0, 0, 0);
            System.out.println("#" + test_case + " " + max);
            max = -1;
        }
    }
     
    private static void combination(int cnt, int start, int total) {
        if (total > M) {
            return;
        }
 
        if (cnt == 2) {
            if (total > max)
                max = total;
            return;
        }
 
        for (int i = start; i < N; i++) {
            combination(cnt + 1, i + 1, total + input[i]);
        }
    }
     
}