/**
 * Class for node.
 */
class Node {
    /**
     * varible for key.
     */
    private Book key;
    /**
     * varible for value.
     */
    private String value;
    /**
     * varible for left node.
     */
    private Node left;
    /**
     * varible for right node.
     */
    private Node right;
    /**
     * varible for count.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      key1    The key 1
     * @param      value1  The value 1
     * @param      count1  The count 1
     */
    Node(final Book key1, final String value1, final int count1) {
        this.key = key1;
        this.value = value1;
        this.count = count1;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public String getValue() {
        return value;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Gets the count.
     *
     * @return     The count.
     */
    public int getCount() {
        return count;
    }
    /**
     * Sets the left.
     *
     * @param      left1  The left 1
     */
    public void setLeft(final Node left1) {
        this.left = left1;
    }
    /**
     * Sets the right.
     *
     * @param      right1  The right 1
     */
    public void setRight(final Node right1) {
        this.right = right1;
    }
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    public void setValue(final String val) {
        this.value = val;
    }
    /**
     * Sets the count.
     *
     * @param      cnt   The count
     */
    public void setCount(final int cnt) {
        this.count = cnt;
    }
}
