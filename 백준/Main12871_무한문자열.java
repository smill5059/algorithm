import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = in.readLine();
		String str2 = in.readLine();
				
		boolean result;
		if (str1.length() < str2.length())
			result = isSame(str1, str2);
		else
			result = isSame(str2, str1);
		
		System.out.println(result?1:0);
	}
	
	private static boolean isSame(String shortOne, String longOne) {
		
		int slen = shortOne.length();
		int llen = longOne.length();
		
		boolean result = true;
		char[] s = shortOne.toCharArray();
		char[] l = longOne.toCharArray();
		int j = 0;
		for (int i = 0; i < llen*2; i++) {
			if (l[i%llen] != s[j%slen]) {
				result = false;
				break;
			}
			j++;
		}
		
		return result;
	}
}