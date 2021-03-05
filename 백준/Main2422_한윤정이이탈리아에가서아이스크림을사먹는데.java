import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, total;
	private static int[] selected;
	private static List[] noMix;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		noMix = new List[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			addList(a, b);
			addList(b, a);
		}
		
		selected = new int[3];
		combination(1, 0);
		System.out.println(total);
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				List<Integer> list = noMix[selected[i]];
				if (list == null) continue;
				for (int j = i; j < 3; j++) {
					if (list.contains(selected[j])) return;
				}
			}
			total++;
			return;
		}
		
		for (int i = start; i <= N; i++) {
			selected[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	
	private static void addList(int a, int b) {
		if (noMix[a] == null) {
			noMix[a] = new ArrayList<Integer>();
		}
		noMix[a].add(b);
	}
}