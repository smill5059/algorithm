import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
     
    static int N, d, k, c;
    static int[] dishes, selected;
     
    static int max;
     
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dishes = new int[N];
        selected = new int[d+1];        
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(in.readLine());
        }
         
         
        int cnt = 0, total = 0;
        for (int i = 0; i < N+k; i++) {
            cnt++;
             
            if (cnt > k) {
                int front = dishes[i-k];
                selected[front]--;
                if (selected[front] == 0) total--;
            }
             
            int cur;
            if (i >= N) cur = dishes[i-N];
            else cur = dishes[i];
            if (selected[cur] == 0) total++;
            selected[cur]++;
             
            if (cnt < k) continue;
             
            if (selected[c] == 0) total++;
            if (total > max) max = total;
            if (max >= k+1) break;
            if (selected[c] == 0) total--;
        }
        System.out.println(max);
         
    }
}