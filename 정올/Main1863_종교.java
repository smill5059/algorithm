import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
     
    static int N, M;
    static int[] parents;
     
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        String str = in.readLine();
        st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
         
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
         
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            str = in.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
            union(a, b);
        }
                 
        //다른 숫자 몇개 있는지 찾기
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == i) {
                cnt++;              
            }
        }
        System.out.println(cnt);
    }
     
    static int find(int a) {
        if (parents[a] == a) {
            return a;           
        }
         
        return parents[a] = find(parents[a]);
    }
     
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
         
        parents[bRoot] = aRoot;
        return true;
    }
}