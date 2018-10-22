import java.util.Scanner;
import java.util.Arrays;
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
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
                case "put": Arrays.toString(tokens); 
                            break;
                case "get": Arrays.toString(tokens);
                            break;
                case "floor": Arrays.toString(tokens); 
                              break;
                case "ceiling": Arrays.toString(tokens);
                                break;
                case "min":     Arrays.toString(tokens);
                                break;
                case "max":     Arrays.toString(tokens);
                                break;
                case "select":  Arrays.toString(tokens);
                                break;
            }
        }
	}
}