import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for (int i = E; i <= 7980; i+=15) {
			
			if ((i%28 == S || (S == 28 && i%28 == 0)) && (i%19 == M || (M == 19 && i%19 == 0))) {
				System.out.println(i);
				break;
			}
		}
	}
}