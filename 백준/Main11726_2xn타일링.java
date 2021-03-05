import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] fib = new int[1001];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = (fib[i-1] + fib[i-2]) % 10007;
		}
		
		System.out.println(fib[n]);
	}
}