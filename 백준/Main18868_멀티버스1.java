import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N; // 학급 수, 학생 수
	static int[][] grades; // 성적 배열
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader 선언, 생성
		StringTokenizer st = new StringTokenizer(in.readLine(), " "); // 공백을 기준으로 입력받은 값을 나눈다
		
		M = Integer.parseInt(st.nextToken()); // 학급 수 대입
		N = Integer.parseInt(st.nextToken()); // 학생 수 대입
		grades = new int[M][N]; // 성적 배열 생성
		for (int i = 0; i < M; i++) { // 학급 수만큼 반복
			st = new StringTokenizer(in.readLine(), " "); // 줄 단위로 입력을 받는다
			for (int j = 0; j < N; j++) { // 학생 수만큼 반복
				grades[i][j] = Integer.parseInt(st.nextToken()); // 학생 수만큼 입력받은 값을 나눠 성적 배열에 대입한다
			}
		}
		
		System.out.println(permutation()); // 실력이 비슷한 학급 쌍의 개수 출력
		
	}// end main
	
	// 학급 쌍을 고르기 위한 순열
	private static int permutation() {
		int cnt = 0; // 실력이 비슷한 학급 쌍의 개수를 세기 위한 변수
		for (int i = 0; i < M-1; i++) { // 0부터 M-2까지 반복한다
			for (int j = i+1; j < M; j++) { // i 뒤부터 M-1까지 반복한다 -->> 구성이 다른 순서쌍을 뽑기 위한 반복
				
				if (check(i, j)) ++cnt; // 실력이 비슷한지 체크해서 비슷하면 1 증가
				
			}
		}
		return cnt; // cnt를 반환한다
	} // end permutation
	
	// 학급 실력을 비교하기 위한 메소드, 비교할 두 학급을 인자로 받는다
	private static boolean check(int a, int b) {
		boolean flag = true; // 부호가 다른 쌍이 있는지 확인하기 위한 변수
		for (int i = 0; i < N-1; i++) { // 0부터 N-2까지 반복한다
			for (int j = i+1; j < N; j++) { // i 뒤부터 N-1까지 반복한다
				
				int diffA = grades[a][i] - grades[a][j]; // Ai>Aj이면 양수, Ai=Aj이면 0, Ai<Aj이면 음수
				int diffB = grades[b][i] - grades[b][j]; // Bi>Bj이면 양수, Bi=Bj이면 0, Bi<Bj이면 음수
				if (Integer.signum(diffA) != Integer.signum(diffB)) { // 두 쌍의 조건이 다르면
					flag = false; // flag를 false로 하고
					break; // 반복문을 종료한다
				}
				
			}
		}
		return flag; // 두 쌍의 조건이 모두 같았다면 true, 다른 조건이 있었다면 false를 반환
	} // end check
}