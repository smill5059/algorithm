import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] warehouse = new int[1001];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			warehouse[L] = H;
		}

		int max = 0, idx = 0; //max:꼭대기, idx:꼭대기위치
		for (int i = 1; i <= 1000; i++) {
			if (warehouse[i] > max) {
				max = warehouse[i];
				idx = i;
			}
		}
		
		int cur = 0, totalArea = 0;
		for (int i = 0; i < idx; i++) {
			totalArea += cur;
			if (cur < warehouse[i+1]) {
				cur = warehouse[i+1];
			}
		}
		cur = warehouse[1000];
		for (int i = 1000; i > idx; i--) {
			totalArea += cur;
			if (cur < warehouse[i-1]) {
				cur = warehouse[i-1];
			}
		}
		totalArea += max;
		System.out.println(totalArea);
	}
}