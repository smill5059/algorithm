import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;	
	static int[] numbers;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		numbers = new int[N];
		selected = new boolean[N+1];
		Arrays.fill(selected, true);
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
				
		boolean flag = false;
		int i;
		
		selected[numbers[N-1]] = false;
		for (i = N-2; i >= 0; i--) {
			selected[numbers[i]] = false;
			while (true) {
				++numbers[i];
				if (numbers[i] > N) break;
				if (selected[numbers[i]] == false) {
					selected[numbers[i]] = true;
					flag = true;
					break;
				}
			}
			if (flag == true) break;
		}
		
		if (flag == false) {
			System.out.println(-1);
			return;
		}
		
		for (int j = i+1; j < N; j++) {
			int temp = findMininum();
			selected[temp] = true;
			numbers[j] = temp;
		}
		for (int j = 0; j < N; j++) {
			System.out.print(numbers[j] + " ");
		}
	}
	
	private static int findMininum() {
		for (int i = 1; i <= N; i++) {
			if (selected[i] == false) return i;
		}
		return -1;
	}
}