/**
 * Class for bst.
 */
class Bst {
    /**
     * varible for root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    Bst() {

    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return count() == 0;
    }
    /**
     * keeps track of count.
     *
     * @return     { integer }
     */
    public int count() {
        return count(root);
    }
    /**
     * keeps track of count.
     *
     * @param      x     { Node }
     *
     * @return     { Node type }
     */
    private int count(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.getCount();
        }
    }
    /**
     * Determines whether key is present.
     *
     * @param      key   The key
     *
     * @return     { boolean }
     */
    public boolean contains(final Book key) {
        return get(key) != null;
    }
    /**
     * Method to insert the key.
     *
     * Time complexity is O(N).
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final String value) {
        root = put(root, key, value);
    }
    /**
     * Method to insert the keys.
     * Time complexity is O(N) in worst case.
     * @param      x      The node.
     * @param      key    The key
     * @param      value  The value
     *
     * @return     The node.
     */
    public Node put(final Node x, final Book key, final String value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.getName().compareTo(x.getKey().getName());
        if (cmp < 0) {
            x.setLeft(put(x.getLeft(), key, value));
        }
        if (cmp > 0) {
            x.setRight(put(x.getRight(), key, value));
        }
        if (cmp == 0) {
            x.setValue(value);
        }
        x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
        return x;
    }
    /**
     * Method to get value of the key.
     * Time complexity of this method is O(N).
     * @param      key   The key
     *
     * @return     The value of the key
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.getKey().getName());
            if (cmp < 0) {
                x = x.getLeft();
            }
            if (cmp > 0) {
                x = x.getRight();
            }
            if (cmp == 0) {
                return x.getValue();
            }
        }
        return null;
    }
    /**
     * Returns the smallest key in the symbol table.
     *
     * Time complexity of this method is O(N).
     *
     * @return     { Book type }
     */
    public Book min() {
        return min(root).getKey();
    }
    /**
     * Returns the minimum key in the symbol table.
     *
     * @param      x     { Node }
     *
     * @return     { Node type }
     */
    private Node min(final Node x) {
        if (x.getLeft() == null) {
            return x;
        } else {
            return min(x.getLeft());
        }
    }
    /**
     * Returns the largest key in the symbol table.
     *
     * Time complexity of this method is O(N).
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        return max(root).getKey();
    }
    /**
     * Returns the largest key in the symbol table.
     *
     * @param      x     { Node }
     *
     * @return     { Node type }
     */
    private Node max(final Node x) {
        if (x.getRight() == null) {
            return x;
        } else {
            return max(x.getRight());
        }
    }
    /**
     * Returns the largest key in the symbol table less than or equal to.
     *
     * Time complexity of this method is O(N).
     *
     * @param      key   The key
     *
     * @return     { Book type }
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }
    /**
     * Returns the largest key in the symbol table less than or equal to.
     *
     * @param      x     The node
     * @param      key   The key
     *
     * @return     { Node type }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.getLeft(), key);
        }
        Node t = floor(x.getRight(), key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * Returns the smallest key in the symbol table greater than or equal to.
     *
     * Time complexity of this method is O(N).
     *
     * @param      key   The key
     *
     * @return     { Book type }
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }
    /**
     * Returns the smallest key in the symbol table greater than or equal to.
     *
     * Time complexity of this method is O(N).
     *
     * @param      x     The node
     * @param      key   The key
     *
     * @return     { Node type }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.getLeft(), key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.getRight(), key);
    }
    /**
     * Return the key in the symbol table whose rank.
     *
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.getKey();
    }
    /**
     * Return the key in the symbol table whose rank.
     *
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = count(x.getLeft());
        if (t > k) {
            return select(x.getLeft(),  k);
        }
        if (t < k) {
            return select(x.getRight(), k - t - 1);
        }
        if (t == k) {
            return x;
        }
        return x;
    }
    /**
     * To delete the minimum node.
     *
     * Time complexity of this method is O(1).
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * To delete the minimum node.
     * Time complexity of this method is O(N).
     *
     * @param      x     { Node }
     *
     * @return     { Node type }
     */
    private Node deleteMin(final Node x) {
        if (x.getLeft() == null) {
            return x.getRight();
        }
        x.setLeft(deleteMin(x.getLeft()));
        x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
        return x;
    }
    /**
     * To delete the maximum node.
     *
     * Time complexity of this method is O(1).
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * To delete the maximum node.
     *
     * Time complexity of this method is O(N).
     *
     * @param      x     { Node }
     *
     * @return     { Node type }
     */
    private Node deleteMax(final Node x) {
        if (x.getRight() == null) {
            return x.getLeft();
        }
        x.setRight(deleteMax(x.getRight()));
        x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
        return x;
    }
    /**
     * Function to delete a node.
     *
     * @param      key   The key
     */
    public void delete(final Book key) {
        root = delete(root, key);
    }
    /**
     * Function to delete a node.
     *
     * Time complexity of this method is O(N).
     *
     * @param      x     { Node }
     * @param      key   The key
     *
     * @return     { Node type }
     */
    private Node delete(final Node x, final Book key) {
        Node n = x;
        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) {
            x.setLeft(delete(x.getLeft(), key));
        } else if (cmp > 0) {
            x.setRight(delete(x.getRight(), key));
        } else {
            if (x.getRight() == null) {
                return x.getLeft();
            }
            if (x.getLeft()  == null) {
                return x.getRight();
            }
            Node t = x;
            n = min(t.getRight());
            x.setRight(deleteMin(t.getRight()));
            x.setLeft(t.getLeft());
        }
        x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
        return n;
    }
}
