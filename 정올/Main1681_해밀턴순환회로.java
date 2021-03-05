import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    static int N;
    static int[][] adjMatrix;
    static boolean[] visited;
 
    static int min;
    static boolean flag;
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(in.readLine());
        adjMatrix = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        min = Integer.MAX_VALUE;
        deliver(0, 0, 0);
        if (!flag) min = 0;
        System.out.println(min);
    }
 
    private static void deliver(int cur, int total, int cnt) {
        if (total > min) return;
 
        if (cnt == N-1) {
            if (adjMatrix[cur][0] > 0) {
                flag = true;
                if (total+adjMatrix[cur][0] < min) min = total+adjMatrix[cur][0];
            }
            return;
        }
 
        for (int i = 1; i < N; i++) {
            if (adjMatrix[cur][i] <= 0) continue;
            if (visited[i]) continue;
             
            visited[i] = true;
            deliver(i, total + adjMatrix[cur][i], cnt + 1);
            visited[i] = false;
        }
 
    }
}