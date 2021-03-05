import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int num = Integer.parseInt(in.readLine());
			
			howMany(num);
			System.out.println(cnt);
			cnt = 0;
		}
	}
	
	private static void howMany(int num) {
		
		if (num == 0) {
			++cnt;
			return;
		}
		
		if (num < 0) {
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			howMany(num-i);
		}
	}
}