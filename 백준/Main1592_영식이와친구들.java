import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] friend = new int[N];
		int[] cnt = new int[N]; //공을 받은 횟수
		int cur = 0, total = 0;
		while (true) {
			if (++cnt[cur] == M) break;
			++total;
			
			if (cnt[cur]%2 == 0) { //짝수:반시계
				cur -= L;
				if (cur < 0) cur = N+cur;
			}else { //홀수:반시계
				cur += L;
				if (cur >= N) cur = cur-N;
			}
		}
		System.out.println(total);
	}
}