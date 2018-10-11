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
     * @param      roots  The root
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