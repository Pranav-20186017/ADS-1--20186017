import java.util.Scanner;
class StarString {
	public String generateStarString(String st) {
		String result = "";
		if (st == null) {
			return st;
		}
		result = st.substring(0,1);
		if (st.trim().length() == 1) {
			return result;
		}
		if (result.equals(st.substring(1,2))) {
			result += "*";
		}
		st = st.substring(1);
		return result + generateStarString(st);
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		StarString starstring = new StarString();
		System.out.println(starstring.generateStarString(line));
	}
}