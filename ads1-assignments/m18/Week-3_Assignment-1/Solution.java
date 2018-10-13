import java.util.Scanner;
class Stock implements Comparable <Stock> {
	private String ticker;
	private float change;
	Stock(String name, float percent) {
		this.ticker = name;
		this.change = percent;
	}
	public String getName() {
		return this.ticker;
	}
	public float getChange() {
		return this.change;
	}
	public int compareTo(Stock other) {
		if (this.change > other.change) {
			return 1;
		}
		if (this.change < other.change) {
			return -1;
		}
		if (this.ticker.compareTo(other.ticker) > 0) {
			return 1;
		}
		if (this.ticker.compareTo(other.ticker) < 0) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		return this.ticker + " " + this.change;
	}
}
class Solution {
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < 6; i++) {
			int count = 0;
			MinPQ<Stock> minpq = new MinPQ<>();
			MaxPQ<Stock> maxpq = new MaxPQ<>();
			while (count < num) {
				String[] tokens = scan.nextLine().split(",");
				Stock stock = new Stock(tokens[0], Float.parseFloat(tokens[1]));
				minpq.insert(stock);
				maxpq.insert(stock);
				count++;
			}
			BinarySearchTree<String, Float> stockbest = new  BinarySearchTree<>();
			BinarySearchTree<String, Float> stockworst = new BinarySearchTree<>();
			for (int j = 0; j < 5; j++) {
				Stock maxpqbest = maxpq.delMax();
				System.out.println(maxpqbest);
				stockbest.put(maxpqbest.getName(), maxpqbest.getChange());
			}
			System.out.println();
			for(int k = 0; k < 5; k++) {
				Stock minpqworst = minpq.delMin();
				System.out.println(minpqworst);
				stockworst.put(minpqworst.getName(), minpqworst.getChange());
			}
			System.out.println();
		}
	}
}