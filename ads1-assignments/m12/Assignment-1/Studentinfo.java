/**
 * Class for Studentinfo.
 */
class Studentinfo implements Comparable<Studentinfo> {
    String sname;
    String bday;
    int m1;
    int m2;
    int m3;
    int totalvals;
    String rescat;
    /**
     * Constructs the object.
     *
     * @param      name      The name
     * @param      dob       The dob
     * @param      sub1      The sub 1
     * @param      sub2      The sub 2
     * @param      sub3      The sub 3
     * @param      total     The total
     * @param      category  The category
     */
    Studentinfo(final String name, final String dob, final int sub1,
        final int sub2, final int sub3,
        final int total, final String category) {
        this.sname = name;
        this.bday = dob;
        this.m1 = sub1;
        this.m2 = sub2;
        this.m3 = sub3;
        this.totalvals = total;
        this.rescat = category;
    }
    /**
     * Splits a date.
     *
     * @return     {String array of date split with a delimiter}
     */
    public String[] splitDate() {
        String[] splitdate = bday.split("-");
        return splitdate;
    }
    /**
     * compares two objects of same class.
     *
     * @param      other  The other
     *
     * @return     { returns an integer based on the truth value }
     */
    public int compareTo(final Studentinfo other) {
        if (this.totalvals > other.totalvals) {
            return 1;
        }
        if (this.totalvals < other.totalvals) {
            return -1;
        }
        if (this.m3 > other.m3) {
            return 1;
        }
        if (this.m3 < other.m3) {
            return -1;
        }
        if (this.m2 > other.m2) {
            return 1;
        }
        if (this.m2 < other.m2) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[2])
            > Integer.parseInt(other.splitDate()[2])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[2])
            < Integer.parseInt(other.splitDate()[2])) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[1])
            > Integer.parseInt(other.splitDate()[1])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[1])
            < Integer.parseInt(other.splitDate()[1])) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[0])
            > Integer.parseInt(other.splitDate()[0])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[0])
            < Integer.parseInt(other.splitDate()[0])) {
            return -1;
        }
        return 0;
    }

}