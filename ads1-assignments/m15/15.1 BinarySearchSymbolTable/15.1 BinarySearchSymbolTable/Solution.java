import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**.
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchST bs = new BinarySearchST();
        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            bs.put(tokens[i], i);
        }
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens1 = input.split(" ");
            switch (tokens1[0]) {
                case "get":
                    System.out.println(bs.get(tokens1[1]));
                break;

                case "max":
                    System.out.println(bs.max());
                break;

                case "floor":
                    System.out.println(bs.floor(tokens1[1]));
                break;

                case "rank":
                    System.out.println(bs.rank(tokens1[1]));
                break;

                case "contains":
                    System.out.println(bs.contains(tokens1[1]));
                break;

                case "deleteMin":
                    bs.deleteMin();
                break;

                case "keys":
                    System.out.println(bs.keys());
                break;

                default:
                break;
            }
        }
    }
}
