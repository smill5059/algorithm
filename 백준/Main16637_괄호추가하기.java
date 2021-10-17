

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16637_��ȣ�߰��ϱ� {
	private static int N, max;
	private static char input[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		input = in.readLine().toCharArray();
		
		max = Integer.MIN_VALUE;
		dfs(2, input[0]-'0');
		System.out.println(max);
	}
	
	private static void dfs(int idx, int sum) {
		if (idx >= N) {
			max = Math.max(max, sum);
			return;
		}

		/* ��ȣ x */
		int op = input[idx]-'0';
		switch (input[idx-1]) {
		case '+':
			dfs(idx+2, sum+op);
			break;
		case '-':
			dfs(idx+2, sum-op);
			break;
		case '*':
			dfs(idx+2, sum*op);
			break;
		}
		
		/* ��ȣ o */
		if (idx < N-1) {
			op = 0;
			switch (input[idx+1]) {
			case '+':
				op = (input[idx]-'0') + (input[idx+2]-'0');
				break;
			case '-':
				op = (input[idx]-'0') - (input[idx+2]-'0');
				break;
			case '*':
				op = (input[idx]-'0') * (input[idx+2]-'0');
				break;
			}
			
			switch (input[idx-1]) {
			case '+':
				dfs(idx+4, sum+op);
				break;
			case '-':
				dfs(idx+4, sum-op);
				break;
			case '*':
				dfs(idx+4, sum*op);
				break;
			}
		}
		
	}
}
