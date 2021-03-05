import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (number == 1) continue;
			if (isPrime(number)) ++cnt;
		}
		System.out.println(cnt);
	}
	
	private static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number%i == 0) return false;
		}
		return true;
	}
}