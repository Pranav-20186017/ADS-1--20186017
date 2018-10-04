import java.util.Scanner;
/**
 * Class for star string.
 */
class StarString {
	/**
	 * generate the string with *'s.
	 *
	 * @param      st    { of type String}
	 *
	 * @return     { modified string with stars}
	 */
	public String generateStarString(String st) {
		String result = "";
		if (st == null) {
			return st;
		}
		result = st.substring(0, 1);
		if (st.trim().length() == 1) {
			return result;
		}
		if (result.equals(st.substring(1, 2))) {
			result += "*";
		}
		st = st.substring(1);
		return result + generateStarString(st);
	}
}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused.
	}
	/**
	 * main fucntion.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		StarString starstring = new StarString();
		System.out.println(starstring.generateStarString(line));
	}
}