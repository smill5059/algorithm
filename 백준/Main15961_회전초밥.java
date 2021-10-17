package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15961_ȸ���ʹ� {
	private static int N, d, k, c, belt[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		}
		
		int result = solve();
		System.out.println(result);
	}
	
	private static int solve() {
		int[] howManySelected = new int[d+1];
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (howManySelected[belt[i]]++ == 0) max++;
		}
		int cnt = max; // ���� ��ġ �߿�!
		// cnt�� ���� �ʹ��� ���� �Ǹ� �ڿ��� �ߺ� �����
		// cnt�� ��Ȯ�ϰ� � �����͸� �ǹ��ϴ��� �˾ƾ� ��
		if (howManySelected[c] == 0) max++;
		
		for (int i = 1; i < N; i++) {
			if (--howManySelected[belt[i-1]] == 0) cnt--;
			if (howManySelected[belt[(i-1+k)%N]]++ == 0) cnt++;
			if (howManySelected[c] == 0) {
				max = Math.max(max, cnt+1);
			} else {
				max = Math.max(max, cnt);
			}
		}
		
		return max;
	}
}
