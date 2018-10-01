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
    	/**
    	 * variable to hold data.
    	 */
        private int data;
        /**
         * variable to point towards the next Link.
         */
        private Node next;
    }
    /**
     * variable that is at the start of the Linked List.
     */
    private Node head;
    /**
     * variable that is at the end of the Linked List.
     */
    private Node tail;
    /**
     * varibale to measure the size of the Linked List
     */
    private int size = 0;
    /**
     * This method pushes an element i.e creates a new head in the linked list.
     * This mehtod pertains to the stack portion of the Stqueue.
     * Thus it follows the LIFO logic.
     * Since insertions are done purely based on creating a new head,
     * the Time Complexity  O(1), this is also because in an unordered linked list
     * insertions take O(1) time irrespective of the size.
     * @param      val {is of type integer}.
     */
    public void push(final int val) {
    	/**
    	 * create a new node in the Linked List.
    	 */
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
     * This method enqueues an element i.e. adds the new element at the end of the stqueue
     * Therefore its ultimatley creating a new tail.
     * Thus it follows the FIFO Logic.
     * Since insertions are done purely based on creating a new tail,
     * the Time Complexity O(1), this is also because in an unordered linked lsit
     * insertions take O(1) time irrespective of the size.
     * @param      val   {is of type integer}
     */
    public void enqueue(final int val) {
    	/**
    	 * create a new node in the Linked List.
    	 */
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
     * this method employs the LIFO logic.
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