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
    private Node head;
    private Node tail;
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
     * Note: This function is used to pop the elements from the stack end.
     * Time Complexity O(1) - Constant Time.
     * The time taken to severe the head is always constant irrespective of the size
     * of the linked list that is used to implement the stequeue.
     */
    public void pop() {
        head = head.next;
        size--;
    }
    /**
     * Determines if empty.
     * Time Complexity O(1) -- Constant Time
     * Since only one varible i.e. size has to be accessed, this function always takes constant time.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * this function prints the contents of the stequeue.
     * time complexity O(N) -- Linear Time.
     * @return     {a String containing elments from the stequeue in the specified format}
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