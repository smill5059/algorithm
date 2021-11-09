package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2036_수열의점수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		List<Long> plus = new ArrayList<>();
		List<Long> minus = new ArrayList<>();
		int zero = 0;
		int one = 0;
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			Long num = Long.parseLong(in.readLine());
			if (num == 0) {
				zero++;
			} else if (num == 1) {
				one++;
			} else if (num > 0) {
				plus.add(num);
			} else if (num < 0) {
				minus.add(num);
			}
		}
		
		long result = 0;
		/* 양수 더하기 */
		plus.sort(Comparator.reverseOrder());
		int plusSize = plus.size();
		for (int i = 0; i < plusSize-1; i+=2) {
			result += (plus.get(i)*plus.get(i+1));
		}
		if (plusSize%2 == 1) {
			result += plus.get(plusSize-1);
		}
		/* 1 더하기 */
		for (int i = 0; i < one; i++) {
			result += 1;
		}
		/* 음수 더하기 */
		minus.sort(Comparator.naturalOrder());
		int minusSize = minus.size();
		for (int i = 0; i < minusSize-1; i+=2) {
			result += (minus.get(i)*minus.get(i+1));
		}
		if (minusSize%2 == 1) {
			if (zero == 0) {
				result += minus.get(minusSize-1);
			}
		}
		
		System.out.println(result);
	}
}
