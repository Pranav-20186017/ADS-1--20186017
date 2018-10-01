import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object for the class Solution.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * {Main Method}.
     *Time Complexity of this method is O(N^2).
     *Since one loop is written inside the other.
     *One loop is for counting the number of testcases.
     *the other is to run the opetaions specified in the test case.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] tokens;
        String word = "";
        LinkedList linkedlist;
        while (n > 0) {
            linkedlist = new LinkedList();
            while (s.hasNext()) {
                word = s.nextLine();
                if (word.isEmpty()) {
                    break;
                }
                tokens = word.split(" ");
                switch (tokens[0]) {
                case "push":
                    linkedlist.push(Integer.parseInt(tokens[1]));
                    System.out.println(linkedlist.print());
                    break;
                case "enqueue":
                    linkedlist.enqueue(Integer.parseInt(tokens[1]));
                    System.out.println(linkedlist.print());
                    break;
                case "pop":
                    if (!(linkedlist.isEmpty())) {
                        linkedlist.pop();
                    }
                    System.out.println(linkedlist.print());
                    break;
                default :
                    break;
                }
            }
            n--;
            System.out.println();
        }
    }
}
