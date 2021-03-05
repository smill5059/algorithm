import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			String operator = st.nextToken();
			
			if (operator.equals("add")) {
				int operand = Integer.parseInt(st.nextToken());
				add(operand);
			} else if (operator.equals("remove")) {
				int operand = Integer.parseInt(st.nextToken());
				remove(operand);
			} else if (operator.equals("check")) {
				int operand = Integer.parseInt(st.nextToken());
				sb.append(check(operand) + "\n");
			} else if (operator.equals("toggle")) {
				int operand = Integer.parseInt(st.nextToken());
				toggle(operand);
			} else if (operator.equals("all")) {
				all();
			} else if (operator.equals("empty")) {
				empty();
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void add(int x) {
		if (check(x) == 0)
			list.add(x);
	}
	
	private static void remove(int x) {
		if (check(x) == 1)
			list.remove(list.indexOf(x));
	}
	
	private static int check(int x) {
		if (list.contains(x))
			return 1;
		else
			return 0;
	}
	
	private static void toggle(int x) {
		if (list.contains(x))
			list.remove(list.indexOf(x));
		else
			list.add(x);
	}
	
	private static void all() {
		list.clear();
		for (int i = 1; i <= 20; i++) {
			list.add(i);
		}
	}
	
	private static void empty() {
		list.clear();
	}
}