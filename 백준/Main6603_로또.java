import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[] s, lotto;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			s = new int[k];
			lotto = new int[6];
			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			System.out.println();
		}
	}
	
	private static void combination(int start,int cnt) {
		
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < k; i++) {
			lotto[cnt] = s[i];
			combination(i+1, cnt+1);
		}
	}
}