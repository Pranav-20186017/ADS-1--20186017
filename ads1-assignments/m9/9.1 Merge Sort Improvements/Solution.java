import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = "";
		String[] tokens;
		while(s.hasNext()) {
			line = s.nextLine();
			tokens = line.split(",");
			int[] vals = new int[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				vals[i] = Integer.parseInt(tokens[i]);
			}
			System.out.println(Arrays.toString(vals));
		}
	}
}