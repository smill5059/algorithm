import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] numbers = new int[N+1];
		int[] line = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			int idx = i;
			int number = numbers[i];
			for (int j = idx; j > idx-number; j--) {
				line[j] = line[j-1];
			}
			line[idx-number] = idx;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(line[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}