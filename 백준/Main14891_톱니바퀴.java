import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static char[][] gear;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		gear = new char[5][8];
		for (int i = 1; i <= 4; i++) {
			gear[i] = in.readLine().toCharArray();
		}
		
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); //1:시계, -1:반시계
			move(n, d);
		}
		
		int result = 0;
		for (int i = 1; i <= 4; i++) {
			if (gear[i][0] - '0' == 1)
				result |= 1 << (i-1);
		}
		System.out.println(result);
	}
	
	private static void move(int n, int d) {
		int[] check = new int[5];
		check[n] = d;
		int direction = d;
		for (int i = n; i < 4; i++) {
			if (gear[i][2] == gear[i+1][6]) break;
			direction *= -1;
			check[i+1] = direction;
		}
		direction = d;
		for (int i = n; i > 1; i--) {
			if (gear[i][6] == gear[i-1][2]) break;
			direction *= -1;
			check[i-1] = direction;
		}
		
		for (int i = 1; i <= 4; i++) {
			rotate(i, check[i]);
		}
	}
	
	private static void rotate(int n, int d) {
		if (d == 1) {
			char temp = gear[n][7];
			for (int i = 7; i > 0; i--) {
				gear[n][i] = gear[n][i-1];
			}
			gear[n][0] = temp;
		}
		else if (d == -1) {
			char temp = gear[n][0];
			for (int i = 0; i < 7; i++) {
				gear[n][i] = gear[n][i+1];
			}
			gear[n][7] = temp;
		}
	}
}