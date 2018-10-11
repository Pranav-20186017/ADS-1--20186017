
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
