import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S;
	static int[] input, sets;

	static int R, total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			R = i;
			sets = new int[R];
			combination(0, 0);
		}
		System.out.println(total);
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += sets[i];
			}
			if (sum == S)
				++total;
			return;
		}
		
		for (int i = start; i < N; i++) {
			sets[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}
}