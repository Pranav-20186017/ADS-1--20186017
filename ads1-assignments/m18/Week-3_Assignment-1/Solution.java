import java.util.Scanner;
import java.util.Arrays;
class Stock {
	String name;
	double percent;
	Stock(final String ticker, final float pchange) {
		this.name = ticker;
		this.percent = pchange;
	}
	public String toString() {
		return name + " " + percent;
	}
}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0 ; i < n; i++) {
			String line = s.nextLine();
			String[] tokens = line.split(", ");
			System.out.println(Arrays.toString(tokens));
			// String ticker = tokens[0];
			// float percent = Float.parseFloat(tokens[1]);
			// Stock stock = new Stock(ticker, percent);
			// System.out.println(stock.toString());
		}
	}
}