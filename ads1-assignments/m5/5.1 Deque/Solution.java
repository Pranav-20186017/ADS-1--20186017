import java.util.Scanner;
/**
 * Class for deque.
 *
 * @param      <Item>  The item
 */
class Deque<Item> {
    /**
     * node pointer pointing towards head.
     */
    private Node first = null;
    /**
     * node pointer pointing towards tail.
     */
    private Node last = null;
    /**
     * size of the data strucure.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
         * data of type item.
         */
        private Item data;
        /**
         * pointer to next placeholder.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      information  The information
         */
        Node(final Item information) {
            this.data = information;
        }
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Pushes an element right.
     *
     * @param      element  The element
     */
    public void pushRight(final Item element) {
        Node oldleft = last;
        last = new Node(element);
        if (isEmpty()) {
            first = last;
            last.next = null;
            size++;
            printList();
            return;
        }
        last.next = null;
        oldleft.next = last;
        size++;
        printList();
    }
    /**
     * Pushes an element left.
     *
     * @param      element  The element
     */
    public void pushLeft(final Item element) {
        Node oldright = first;
        first = new Node(element);
        if (isEmpty()) {
            last = first;
            size++;
            printList();
            return;

        }
        first.next = oldright;
        size++;
        printList();
    }
    /**
     * pops the item to the left.
     *
     * @return     {is of type item.}
     */
    public Item popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return null;
        }
        Item d = first.data;
        if (isEmpty()) {
            return null;
        }
        first = first.next;
        size--;
        printList();
        return d;
    }
    /**
     * pops the item to the right.
     *
     * @return     {is of type Item.}
     */
    public Item popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return null;
        }
        Item d  =  last.data;
        if (isEmpty()) {
            return null;
        }
        int s = 0;
        Node get = first;
        while (s < size - 2) {
            get = get.next;
            s++;
        }
        last = get;
        size--;
        printList();
        return d;
    }
    /**
     * prints the data structure.
     */
    public void printList() {
        if (size == 0) {
            System.out.println("[]");
            return;
        }
        Node tnode = first;
        String s = "";
        while (tnode != null) {
            s += tnode.data + ",";
            tnode = tnode.next;
        }
        String[] str = s.split(",");
        String pr = "[";
        for (int i = 0; i < size - 1; i++) {
            pr += str[i] + ", ";
        }
        pr += str[size - 1] + "]";
        System.out.println(pr);
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
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> q = new Deque<>();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                q.pushLeft(Integer.parseInt(line[1]));
                break;
            case "pushRight":
                q.pushRight(Integer.parseInt(line[1]));
                break;
            case "popRight":
                q.popRight();
                break;
            case "popLeft":
                q.popLeft();
                break;
            case "size":
                System.out.println(q.getSize());
                break;
            default :
            }
        }

    }
}