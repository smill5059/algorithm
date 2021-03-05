import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, R;
	private static int[][] input, numbers;
	
	static int minDiff;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		input = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = input[0][0] - input[0][1];
		if (minDiff < 0) minDiff = -minDiff;
		for (int i = 1; i <= N; i++) {
			R = i;
			numbers = new int[R][];
			combination(0, 0);
		}
		
		System.out.println(minDiff);
	}

	private static void combination(int cnt, int start) {

		if (cnt == R) {
			int sourSum = 1, bitterSum = 0;
			for (int i = 0; i < R; i++) {
				sourSum *= numbers[i][0];
				bitterSum += numbers[i][1];
			}
			int diff = sourSum - bitterSum;
			if (diff < 0) diff = -diff;
			
			if (diff < minDiff) minDiff = diff;
			
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}

	}
}