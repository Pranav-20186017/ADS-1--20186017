import java.util.*;
class Insertion {
	void sort() {

	}
}
class Solution {
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int n = s.nextInt();
		// System.out.println(n);
		for (int i = 0; i < n; i++) {
			String line = s.nextLine();
			String[] tokens = line.split(" ");
			System.out.println(Arrays.toString(tokens));
		}
	}
}