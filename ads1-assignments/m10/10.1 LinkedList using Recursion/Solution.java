import java.util.Scanner;
class LinkedList {
    private Node head;
    private Node tail;
    public int size;
    private static int index;
    private class Node {
        private int value;
        private Node next;
    }
    LinkedList() {
        head = null;
        tail = null;
    }
    public void insertFront(final int value){
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
    public void removeFront(){
        if (head != null) {
            head = head.next;
            size--;
        }
    }
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
    public void insertAt(int position, int value) {
        insertAt(head, position, value);
    }
    public void insertAt(Node head, int position, int value) {
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
    public void reverse() {
        head = reverseRecursive(head);
    }
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null; 
        return temp;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
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
public class Solution {
    private Solution() {
        //unused.
    }
    public static void main(String[] args) {
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