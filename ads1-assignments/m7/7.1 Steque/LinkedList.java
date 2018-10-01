/**
 * Class for LinkedList.
 */
class LinkedList {
	/**
	 * Constructs the object for the class LinkedList.
	 */
    protected LinkedList() {
    	//unused constructor.
    }
    /**
     * Class for node.
     */
    class Node {
        private int data;
        private Node next;
    }
    private Node head, tail;
    private int size = 0;
    /**
     * { function_description }
     *
     * @param      val   The value
     */
    public void push(final int val) {
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
    /**
     * { function_description }
     *
     * @param      val   The value
     */
    public void enqueue(final int val) {
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
    /**
     * { function_description }
     */
    public void pop() {
        head = head.next;
        size--;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String print() {
        if (size == 0) {
            return "Steque is empty.";
        }
        Node prhead = head;
        int capacity = size;
        String str = "";
        while (capacity > 0) {
            str += prhead.data + ", ";
            prhead = prhead.next;
            capacity--;
        }
        String finalResult = str.substring(0, str.length() - 2);
        return finalResult;
    }
}