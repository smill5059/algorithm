import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		findOriginal(input);
	}

	private static void findOriginal(String str) {

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) { 
			char cur = str.charAt(i);
			if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
				i += 2;
			}
			sb.append(Character.toString(cur));
			i++;
		}
		System.out.println(sb);
	}
	
}