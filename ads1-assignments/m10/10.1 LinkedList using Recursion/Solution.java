import java.util.Scanner;
/**
 * class for LinkedList.
 */
class LinkedList {
    private Node head;
    private Node tail;
    public int size;
    private static int index;
    /**
     * Class for node.
     */
    private class Node {
        private int value;
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        tail = null;
    }
    /**
     * inserts data at the begnining of the linked list.
     *
     * @param      value  The data to be inserted.
     */
    public void insertFront(final int value) {
        if (head == null) {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = null;
            tail = head;
        } else {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = oldHead;
        }
        size++;
    }
    /**
     * insert data at the end of the linked list.
     *
     * @param      value  The data to be inserted.
     */
    public void insertBack(final int value){
        if (tail == null) {
            Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           head = tail;
        }
        else {
           Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           oldTail.next = tail;
        }
        size++;
    }
    /**
     * Removes element from the front of the linked list.
     */
    public void removeFront(){
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    /**
     * Remove element from the end of the linked list.
     */
    public void removeBack(){
        if (tail != null) {
            Node temp = null;
            Node pop = tail;
            Node head1 = head;
            while (head1 != tail){
                temp = head1;
                head1 = head1.next;
            } 
            tail = temp;
            tail.next = null;
            size--;
        }
    }
    /**
     * insert data at paticular position.
     *
     * @param      position  The position
     * @param      value     The value
     */
    public void insertAt(final int position, final int value) {
        insertAt(head, position, value);
    }
    /**
     * insert data at paticular position.
     *
     * @param      head      The head
     * @param      position  The position
     * @param      value     The value
     */
    public void insertAt(final Node head, final int position, final int value) {
        if (position == 0) {
            insertFront(value);
            return;
        }
        if (index + 1 == position) {
            Node newnode = new Node();
            newnode.value = value;
            newnode.next = head.next;
            head.next = newnode;
            index = 0;
            return;
        }
        index++;
        insertAt(head.next, position, value);
    }
    /**
     * reverses the linked list.
     */
    public void reverse() {
        head = reverseRecursive(head);
    }
    /**
     * recursively reverses the linked list.
     *
     * @param      head  The head
     *
     * @return     { returns the node }
     */
    public Node reverseRecursive(final Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null; 
        return temp;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * returns size of the linked list.
     *
     * @return     { size of the linked list }
     */
    public int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}
/**
 * Class for solution.
 */
public class Solution {
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
    public static void main(final String[] args) {
        LinkedList list = new LinkedList();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ");
            switch(tokens[0]) {
                case "insertAt":
                    if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                        tokens[1]) > list.size() + 1) {
                        System.out.println(
                            "Can't insert at this position.");
                    } else {
                        list.insertAt(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                        System.out.println(list.toString());
                    }
                break;
                case "reverse":
                    if (!list.isEmpty()) {
                        list.reverse();
                        System.out.println(list.toString());
                    } else {
                        System.out.println("No elements to reverse.");
                    }
                break;

                default:
                break;
        }
    }
  }
}