import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader 선언, 생성
		StringTokenizer st = new StringTokenizer(in.readLine(), " "); // 공백을 기준으로 입력받은 값을 나눈다
		
		int X = Integer.parseInt(st.nextToken()); // 김싸피 보폭
		int Y = Integer.parseInt(st.nextToken()); // 박싸피 보폭
		int H1 = Integer.parseInt(st.nextToken()); // 김싸피 집
		int H2 = Integer.parseInt(st.nextToken()); // 박싸피 집
		
		int kim = H1, park = H2; // 김싸피, 박싸피의 현재 위치 ->> 초기화는 H1, H2로 한다
		while (true) { // 무한 반복
			if (kim >= H1+10000 || park >= H2+10000) { // 김싸피나 박싸피가 출발 지점에서 10000미터 이상 진행한 경우
				kim = -1; // -1을 대입하고
				break; // 반복문을 종료한다
			}
			
			if (kim > park) park += Y; // 김싸피가 앞에 있으면 박싸피를 진행하고
			else if (kim < park) kim += X; // 박싸피가 앞에 있으면 김싸피를 진행한다
			else if (kim == park) break; // 둘의 위치가 같으면 반복문을 종료한다
		}
		
		System.out.println(kim); // 김싸피의 위치를 출력한다 (김싸피와 박싸피의 위치가 같으므로)
	} // end main
}