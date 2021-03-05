import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, max;
	private static int[] card, selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		selected = new int[3];
		combination(0, 0);
		System.out.println(max);
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += selected[i];
			}
			if (sum <= M && sum > max) max = sum;
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[cnt] = card[i];
			combination(i+1, cnt+1);
		}
	}
}