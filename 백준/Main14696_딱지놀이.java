import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		for (int r = 0; r < N; r++) {
			int[][] card = new int[2][5]; //1:세모, 2:네모, 3:동그라미, 4:별
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int cnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < cnt; j++) {
					card[i][Integer.parseInt(st.nextToken())]++;
				}
			}
			
			boolean flag = false;
			for (int i = 4; i >= 1; i--) {
				if (card[0][i] == card[1][i]) continue;
				
				flag = true;
				if (card[0][i] > card[1][i]) sb.append("A\n");
				else if (card[0][i] < card[1][i]) sb.append("B\n");
				break;
			}
			if (!flag) sb.append("D\n");
		}
		
		System.out.print(sb.toString());
	}
}