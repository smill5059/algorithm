import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(in.readLine()); //케이크의 길이
		int[] cake = new int[L+1];
		int N = Integer.parseInt(in.readLine()); //방청객의 수
		int[][] audience = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			audience[i][0] = k-p+1; //기대하는 길이
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					audience[i][1]++;
				}
			}
		}
		
		int expectedMax = 0, realMax = 0;
		int expectedIdx = 0, realIdx = 0;
		for (int i = 1; i <= N; i++) {
			if (audience[i][0] > expectedMax) {
				expectedMax = audience[i][0];
				expectedIdx = i;
			}
			
			if (audience[i][1] > realMax) {
				realMax = audience[i][1];
				realIdx = i;
			}
		}
		
		System.out.println(expectedIdx);
		System.out.println(realIdx);
	}
}