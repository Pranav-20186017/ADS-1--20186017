import java.util.Scanner;
/**
 * Class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String testcases = scan.nextLine();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            int people = Integer.parseInt(line[0]);
            int gap = Integer.parseInt(line[1]);
            Deque<Integer> q = new Deque<>();
            createCircle(q, people);
            q.josephus(people, gap);
        }
    }
    /**
     * Creates a circle.
     *
     * @param      q       The quarter
     * @param      people  The people
     */
    public static void createCircle(final Deque<Integer> q, final int people) {
        for (int i = 0; i < people; i++) {
            q.push(i);
        }
    }
}
