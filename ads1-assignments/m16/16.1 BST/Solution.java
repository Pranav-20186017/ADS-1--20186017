import java.util.Scanner;
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	/**
	 * root of the BST.
	 */
    private Node root;
    /**
     * size of the DS.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        private BookList key;
        private Value val;
        private Node left, right;
        /**
         * Constructs the object.
         */
        Node() {
            //unused.
        }
    }
    /**
     * puts the element onto the BST.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final BookList key, final Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }
    /**
     * puts the element on to the BST.
     *
     * @param      head  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    public Node put(Node head, BookList key, Value val) {
        if (head == null) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            node.left = node.right = null;
            head = node;
            size++;
        }
        int compare = key.compareTo(head.key);
        if (compare < 0) {
            head.left  = put(head.left, key, val);
        } else if (compare > 0) {
            head.right = put(head.right, key, val);
        } else {
            head.val = val;
        }
        return head;
    }
    /**
     * fetches the value associated with the key.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(BookList key) {
        return get(root, key);
    }
    /**
     * fetches the value associated with the key.
     *
     * @param      root  The root
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Value get(Node root, BookList key) {
        if (key == null) {
            System.out.println("key is null");
        }
        
        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return get(root.left, key);
        } else if (compare > 0) {
            return get(root.right, key);
        } else{
            return root.val;
        }
    }
}
/**
 * List of books.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BookList<Key extends Comparable<Key>,Value> {
    String name;
    String author;
    Float cost;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      cost    The cost
     */
    BookList(String name, String author, Float cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets the name.
     *
     * @param      name  The name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Sets the author.
     *
     * @param      author  The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Gets the cost.
     *
     * @return     The cost.
     */
    public float getCost() {
        return this.cost;
    }
    /**
     * Sets the cost.
     *
     * @param      cost  The cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(BookList that) {
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        } else {
            if (this.getAuthor().compareTo(that.getAuthor()) > 0) {
                return 1;
            } else if (this.getAuthor().compareTo(that.getAuthor()) < 0) {
                return -1;
            } else {
                if (this.getCost() > that.getCost()) {
                    return 1;
                } else if (this.getCost() < that.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**.
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
                case "put":
                    bst.put(new BookList(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
                case "get":
                    System.out.println(bst.get(new BookList(tokens[1],
                        tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
                default:
                break;
            }
        }
    }
}