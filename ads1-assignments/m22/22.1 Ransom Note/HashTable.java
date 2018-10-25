/**.
 * Class for hash table.
 */
class HashTable {
    /**.
     * { item_description }
     */
    private final int minusone = -1;
    /**.
     * { var_description }
     */
    private final int fifty = 50;
    /**.
     * { var_description }
     */
    private final int hex = 0x7fffffff;
    /**.
     * { var_description }
     */
    public int num1 = fifty;
    /**.
     * { var_description }
     */
    private Node[] s = new Node[num1];
    /**.
     * Class for node.
     */
    public static class Node {
        /**.
         * { var_description }
         */
        private String key;
        /**.
         * { var_description }
         */
        private int val;
        /**.
         * { var_description }
         */
        private Node next;
        /**.
         * Constructs the object.
         *
         * @param      k   The key
         * @param      v   The value
         * @param      n     { parameter_description }
         */
        protected Node(final String k, final int v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
    }
    /**.
     * computes the index.
     * Complexity: O(1).
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final String key) {
        return (key.hashCode() & hex) % num1;
    }
    /**.
     * inserts data into the hash table.
     * Complexity: O(logN).
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final String key, final int val) {
        int i = hash(key);
        for (Node x = s[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        s[i] = new Node(key, val, s[i]);
    }
    /**.
     * fetches data from the ds.
     * Complexity : O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final String key) {
        int i = hash(key);
        for (Node x = s[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return minusone;
    }
    /**.
     * checks whether or not an element is present in the hash table.
     * Complexity : O(logN)
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final String k) {
        return get(k) != minusone;
    }
}