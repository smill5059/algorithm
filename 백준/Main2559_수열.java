import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 전체 날짜의 수
		int K = Integer.parseInt(st.nextToken()); // 연속적인 날짜의 수
		
		int[] temper = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			temper[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += temper[i];
		}
		int max = sum, j = 0;
		for (int i = K; i < N; i++) {
			sum = sum + temper[i] - temper[j];
			if (sum > max) max = sum;
			j++;
		}
		System.out.println(max);
	}
}