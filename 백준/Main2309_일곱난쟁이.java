import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] height, dwarf, realDwarf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		height = new int[9];
		dwarf = new int[7];
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(in.readLine());
		}
		
		combination(0, 0);
		Arrays.sort(realDwarf);
		for (int i = 0; i < 7; i++) {
			System.out.println(realDwarf[i]);
		}
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += dwarf[i];
			}
			if (sum == 100) {
				realDwarf = Arrays.copyOf(dwarf, dwarf.length);
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			dwarf[cnt] = height[i];
			combination(cnt+1, i+1);
		}
	}
	
}