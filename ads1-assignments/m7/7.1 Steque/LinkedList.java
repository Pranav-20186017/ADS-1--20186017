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