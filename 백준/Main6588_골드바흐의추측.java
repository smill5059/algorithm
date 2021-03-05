import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*골든바흐의 추측*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		
		while (true) {
			int num = Integer.parseInt(in.readLine());
			if (num == 0) break;
			for (int i = 3; i <= num/2; i += 2) {
				if (isPrime(i) && isPrime(num-i)) {
					System.out.println(num + " = " + i + " + " + (num-i));
					flag = true;
					break;
				}
			}
			if (flag == false)
				System.out.println("Goldbach's conjecture is wrong.");
			flag = false;
		}
		
	}
	
	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number%i == 0) return false;
		}
		return true;
	}
}