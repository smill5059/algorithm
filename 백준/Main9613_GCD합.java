import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> numbers;
	static int[] temp;
	static int N;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			
			//초기화
			numbers = new ArrayList<Integer>();
			temp = new int[2];
			sum = 0;
			
			//입력
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				numbers.add(Integer.parseInt(st.nextToken()));
			}
			
			//가능한 모든 쌍의 gcd의 합
			combination(0, 0);
			System.out.println(sum);
			
		}
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == 2) {
			int a = temp[0];
			int b = temp[1];
			if (b > a) {
				int temp = b;
				b = a;
				a = temp;
			}
			
			sum += gcd(a, b);
			return;
		}
		
		for (int i = start; i < N; i++) {
			temp[cnt] = numbers.get(i);
			combination(cnt+1, i+1);
		}
	}
	
	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}