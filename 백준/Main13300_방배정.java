import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); //학생수
		int K = Integer.parseInt(st.nextToken()); //한 방에 배정할 수 있는 최대 인원 수
		
		int[][] students = new int[2][7]; //[성별][학년]
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			students[sex][grade]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				cnt += students[i][j] / K;
				if (students[i][j] % K != 0) cnt++;
			}
		}
		System.out.println(cnt);
	}
}