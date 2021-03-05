import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    private static int[][] road;
    private static boolean flag;
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        while (true) {
            String str = in.readLine();
            if (str == null) break;
            st = new StringTokenizer(str, " ");
            int tc = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
 
            road = new int[100][2];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (road[from][0] == 0) road[from][0] = to;
                else road[from][1] = to;
            }
 
            move(0);
            System.out.print("#" + tc + " ");
            if (flag) System.out.println(1);
            else System.out.println(0);
             
            flag = false;
        }
    }
 
    private static void move(int cur) {
        if (cur == 99) {
            flag = true;
            return;
        }
 
        for (int i = 0; i < 2; i++) {
            if (flag) return;
            if (road[cur][i] != 0) move(road[cur][i]);
        }
    }
}