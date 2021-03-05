import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //시험장의 개수
		int[] A = new int[N]; //시험장에 있는 응시자 수
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		int B = Integer.parseInt(st.nextToken()); //총감독관
		int C = Integer.parseInt(st.nextToken()); //부감독관
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt++;
			int temp = A[i]-B;
			if (temp <= 0) continue;
			if (temp%C == 0) cnt += (temp/C);
			else cnt += (temp/C + 1);			
		}
		
		System.out.println(cnt);
	}
}