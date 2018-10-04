import java.util.Scanner;
class Factorial {
	public long getfactorial(long n) {
		if (n == 0) {
			return 1;
		}
		return n * getfactorial(n -1);
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = Long.parseLong(s.nextLine());
		Factorial factorial = new Factorial();
		System.out.println(factorial.getfactorial(n));
	}
}