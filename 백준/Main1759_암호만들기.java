import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L, C;
	static char[] input, passward;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		passward = new char[L];
		input = new char[C];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		combination(0, 0);
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == L) {
			int vowelcnt = 0, conscnt = 0;
			for (int i = 0; i < L; i++) {
				if (passward[i] == 'a' || passward[i] == 'e' || passward[i] == 'i' 
						|| passward[i] == 'o' || passward[i] == 'u')
					++vowelcnt;
				else
					++conscnt;
			}
			if (vowelcnt >= 1 && conscnt >= 2)
				System.out.println(new String(passward));
			return;
		}
		
		for (int i = start; i < C; i++) {
			passward[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}
}