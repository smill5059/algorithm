import java.util.Arrays;
import java.util.Scanner;


public class Main {
	private static int N;
	private static int[] numbers, input;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		numbers = new int[N];
		isSelected = new boolean[N];
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		
		permutation(0);
	}
	
	private static void permutation(int cnt) {
		
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if (isSelected[i])
				continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}