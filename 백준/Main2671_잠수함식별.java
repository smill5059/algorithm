package net.acmicpc;

import java.util.Scanner;

public class Main2671_����Խĺ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String ptn = "(100+1+|01)+";
		System.out.println(str.matches(ptn)?"SUBMARINE":"NOISE");
	}
}
