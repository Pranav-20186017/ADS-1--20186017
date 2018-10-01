import java.util.Scanner;
/**
 * Class to construct LinkedList
 */
class LinkedList {
	/**
	 * Constructor of the LinkedList Class.
	 */
	protected LinkedList() {
		//unused constructor.
	}
	class Node {
		int data;
		Node next;	
	}
	Node head;
	Node tail;
	int size = 0;
	public void push(int value) {
		Node node = new Node();
		node.data = value;
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
	public int getSize() {
		return size;
	}
	public void enqueue(int value) {
		Node node = new Node();
		node.data = value;
		node.next = null;
		if (tail == null) {
			tail = node;
			head = node;
			size++;
			return;
		}
		node.next = tail;
		tail = node;
		size++;
	}
	public void pop() {
		head = head.next;
		size--;
	}
	public boolean isEmpty() {
		return getSize() == 0;
	}
	public String print() {
		if (isEmpty()) {
			return "Steque is empty";
		}
		Node thead = head;
		int capacity = getSize();
		String result = "";
		while (capacity > 0) {
			result = result + thead.data + ", ";
			thead = thead.next;
			capacity--;
		}
		String finalresult = result.substring(0, result.length() - 2);
		return finalresult;
	}
}
class Solution {
	public static void main(String[] args) {
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
					case "push" : linkedlist.push(Integer.parseInt(tokens[1]));
								  System.out.println(linkedlist.print());
								  break;
					case "enqueue" : linkedlist.enqueue(Integer.parseInt(tokens[1]));
									 System.out.println(linkedlist.print());
									 break;
					case "pop": if (!linkedlist.isEmpty()) {
									linkedlist.pop();
								}
								System.out.println(linkedlist.print());
								break;
					default : break;
				}
				n--;
				System.out.println();
			}
		}
		
	}
}