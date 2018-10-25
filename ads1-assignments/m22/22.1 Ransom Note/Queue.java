import java.util.Iterator;
/**
 * Class for Queue.
 *
 * @param      <E>   { parameter_description }
 */
public class Queue<E> implements Iterable<E> {
	/**
	 * Class for node.
	 */
	private class Node {
		E data;
		Node next;
	}
	private Node head, tail;
	private int size = 0;

	public void enqueue(E data) {
		Node node = new Node();
		node.data = data;
		size++;
		if (tail == null) {
			tail = node;
			head = node;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}

	public E dequeue() {
		E data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public Iterator iterator() {
		return new MyIterator(head);
	}
	/**
	 * Class for my iterator.
	 */
	private class MyIterator implements Iterator {
		Node current;
		/**
		 * Constructs the object.
		 *
		 * @param      first  The first
		 */
		public MyIterator(final Node first) {
			current = first;
		}
		/**
		 * Determines if it has next.
		 *
		 * @return     True if has next, False otherwise.
		 */
		public boolean hasNext() {
			return current !=  null;
		}
		/**
		 * { function_description }
		 *
		 * @return     { description_of_the_return_value }
		 */
		public E next() {
			E data = current.data;
			current = current.next;
			return data;
		}
	}
}
