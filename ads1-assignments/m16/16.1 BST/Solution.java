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
        /**
         * key for booklist.
         */
        private BookList key;
        /**
         * value for booklist.
         */
        private Value val;
        /**
         * pointers for left and right nodes.
         */
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
     * @param      heads  The head
     * @param      keys   The key
     * @param      vals   The value
     *
     * @return     { description_of_the_return_value }
     */
    public Node put(final Node heads, final BookList keys, final Value vals) {
        Node head = heads;
        BookList key = keys;
        Value val = vals;
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
    public Value get(final BookList key) {
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
    private Value get(final Node root, final BookList key) {
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
        } else {
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
class BookList<Key extends Comparable<Key>, Value> {
    /**
     * name of the book.
     */
    private String name;
    /**
     * name of the author.
     */
    private String author;
    /**
     * cost of the book.
     */
    private Float cost;
    /**
     * Constructs the object.
     *
     * @param      namestr    The name
     * @param      authorname  The author
     * @param      costval    The cost
     */
    BookList(final String namestr,
        final String authorname, final Float costval) {
        this.name = namestr;
        this.author = authorname;
        this.cost = costval;
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
     * @param      namestr  The name
     */
    public void setName(final String namestr) {
        this.name = namestr;
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
     * @param      authorname  The author
     */
    public void setAuthor(final String authorname) {
        this.author = authorname;
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
     * @param      costvalue  The cost
     */
    public void setCost(final float costvalue) {
        this.cost = costvalue;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final BookList that) {
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