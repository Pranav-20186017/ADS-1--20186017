import java.util.Scanner;
class LinkedList {
    protected LinkedList() {

    }
    class Node {
        private int data;
        private Node next;
    }
    private Node head, tail;
    private int size = 0;
    public void push(int val) {
        Node node = new Node();
        node.data = val;
        node.next = null;
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }
    public void enqueue(int val) {
        Node node = new Node();
        node.data = val;
        node.next = null;
        if (head == null) {
            tail = node;
            head = tail;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }
    public void pop() {
        head = head.next;
        size--;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public String print() {
        if (size == 0) {
            return "Steque is empty.";
        }
        Node prhead = head;
        int capacity = size;
        String str = "";
        while (capacity > 0) {
            str += Integer.toString(prhead.data) + ", ";
            prhead = prhead.next;
            capacity--;
        }
        return str.substring(0, str.length() - 2);
    }
}
class Solution {
    private Solution() {
    	//unused constructor.
    }
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
