import java.util.Scanner;
import java.util.ArrayList;
class minpq <E> {
	ArrayList<E> list = new ArrayList<E>(); 
	minpq() {

	}

}
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String type = s.nextLine();
		System.out.println(type);
		if (type.equals("String")) {
			minpq<String> m = new minpq<String>();
		}
		if (type.equals("Integer")) {
			minpq<Integer> m = new minpq<Integer>();
		}
		if (type.equals("Double")) {
			minpq<Double> m = new minpq<Double>();
		}
		if (type.equals("Float")) {
			minpq<Float> m = new minpq<Float>();
		}
		int cases = Integer.parseInt(s.nextLine());
		System.out.println(cases);
	}
}