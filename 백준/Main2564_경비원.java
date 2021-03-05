import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input_bj_2564.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(in.readLine());
		int[] location = new int[N+1];
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			switch(d) {
			case 1:
				location[i] = x;
				break;
			case 2:
				location[i] = W+H+(W-x);
				break;
			case 3:
				location[i] = W+H+W+(H-x);
				break;
			case 4:
				location[i] = W+x;
				break;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Math.abs(location[i]-location[N]);
			sum += tmp<(W+H)?tmp:(W+H)*2-tmp;
		}
		System.out.println(sum);
		
		in.close();
	}
}