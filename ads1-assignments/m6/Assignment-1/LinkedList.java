class LinkedList {
	Node first = null;
	int size = 0;
	class Node {
		int data;
		Node next;
		Node(int inputdata) {
			this.data = inputdata;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	void push(int data) {
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
		size++;
	}
	int newpop(int values) {
		Node temp = first;
		int counter = 0;
		while (counter < values - 1) {
			temp = temp.next;
			counter++;
		}
		int res = temp.data;
		size--;
		return res;
	}
	int pop() {
		int output = first.data;
		first = first.next;
		size--;
		return output;
	}
	String print() {
		Node test = first;
		String num = "";
		while (test != null) {
			num = num + test.data;
			test = test.next;
		}
		return num;
	}
	int size() {
		return this.size;
	}

}