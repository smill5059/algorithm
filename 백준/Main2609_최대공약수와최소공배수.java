import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
	}

	// 최대공약수
	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	// 최소공배수
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}