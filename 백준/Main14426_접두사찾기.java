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
		
		String[] set = new String[N];
		for (int i = 0; i < N; i++) {
			set[i] = in.readLine();
		}
		
		int result = 0;
		for (int i = 0; i < M; i++) {
			String test = in.readLine();
next:		for (int j = 0; j < N; j++) {
				if (set[j].contains(test)) {
					int len = test.length();
					for (int k = 0; k < len; k++) {
						if (set[j].charAt(k) != test.charAt(k)) continue next;
					}
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}
}