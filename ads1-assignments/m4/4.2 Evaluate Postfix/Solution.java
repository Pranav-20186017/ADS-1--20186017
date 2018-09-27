import java.util.Scanner;
class StackX {
    /**
     * { first }.
     */
    private Node first = null;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { data }.
         */
        private int data;
        /**
         * { node }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      input  The input
         */
        Node(final int input) {
            this.data = input;
        }
    }
    /**
     * { push }.
     *
     * @param      item  The item
     */
    public void push(final int item) {
        Node newnode = new Node(item);
        newnode.next = first;
        first = newnode;
    }
    /**
     * { pop }.
     *
     * @return     { int type }
     */
    public int pop() {
        int item = first.data;
        first = first.next;
        return item;
    }
    /**
     * prints the node.
     */
    public void print() {
        Node testnode = first;
        while (testnode != null) {
            System.out.println(testnode.data);
            testnode = testnode.next;
        }
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
        //unused
    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Stack postfix = new Stack();
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] tokens = line.split(" ");
        String str = "+*-/";
        for (int i = 0; i < tokens.length; i++) {
            if (!str.contains(tokens[i])) {
                postfix.push(Integer.parseInt(tokens[i]));
                } else {
                    switch (tokens[i]) {
                    case "+":
                        int a = postfix.pop();
                        int b = postfix.pop();
                        postfix.push(a + b);
                        break;
                    case "-":
                        a = postfix.pop();
                        b = postfix.pop();
                        postfix.push(a - b);
                        break;
                    case "*":
                        a = postfix.pop();
                        b = postfix.pop();
                        postfix.push(a * b);
                        break;
                    case "/":
                        a = postfix.pop();
                        b = postfix.pop();
                        postfix.push(a / b);
                        break;
                    default:
                    }
            }
        }
        postfix.print();
    }
}
