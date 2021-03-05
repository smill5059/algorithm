import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[][] video;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb.toString());
	}
	
	private static void quadTree(int x, int y, int end) {
		int cur = video[x][y];
		boolean flag = true;
		
		for (int i = x; (i < x+end) && (flag == true); i++) {
			for (int j = y; (j < y+end) && (flag == true); j++) {
				if (video[i][j] != cur) {
					flag = false;
					sb.append("(");
					quadTree(x, y, end/2);
					quadTree(x, y+end/2, end/2);
					quadTree(x+end/2, y, end/2);
					quadTree(x+end/2, y+end/2, end/2);
					sb.append(")");
				}
			}
		}
		
		if (flag == true)
			sb.append(cur);
	}
}