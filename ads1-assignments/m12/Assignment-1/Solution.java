import java.util.Scanner;
/**
 * Class for insertionsort.
 */
class Insertionsort {
    void exchange(final studentinfo[] list, final int lo, final int hi) {
        studentinfo temp = list[lo];
        list[lo] = list[hi];
        list[hi] = temp;
    }
    boolean less(final studentinfo one, final studentinfo two) {
        return one.compareTo(two) == -1;
    }
    /**
     * sort the elements
     * Time Complexity - O(N^2) - Average Case and Worst Case
     * Time Complexity - Omega(N) - Best Case
     *
     * @param      students  The students
     */
    void sort(final studentinfo[] students) {
        for (int i = 1; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(students[j - 1], students[j])) {
                    exchange(students, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
/**
 * Class for studentinfo.
 */
class studentinfo implements Comparable<studentinfo> {
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
    studentinfo(String name, String dob, int sub1, int sub2, int sub3, int total, String category) {
        this.sname = name;
        this.bday = dob;
        this.m1 = sub1;
        this.m2 = sub2;
        this.m3 = sub3;
        this.totalvals = total;
        this.rescat = category;
    }
    String[] splitDate() {
        String[] splitdate = bday.split("-");
        return splitdate;
    }
    public int compareTo(studentinfo other) {
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
        if (Integer.parseInt(this.splitDate()[2]) > Integer.parseInt(other.splitDate()[2])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[2]) < Integer.parseInt(other.splitDate()[2])) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[1]) > Integer.parseInt(other.splitDate()[1])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[1]) < Integer.parseInt(other.splitDate()[1])) {
            return -1;
        }
        if (Integer.parseInt(this.splitDate()[0]) > Integer.parseInt(other.splitDate()[0])) {
            return 1;
        }
        if (Integer.parseInt(this.splitDate()[0]) < Integer.parseInt(other.splitDate()[0])) {
            return -1;
        }
        return 0;
    }

}
class Solution {
    Solution() {
        //unused
    }
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        studentinfo[] students = new studentinfo[num];
        int vac = Integer.parseInt(s.nextLine());
        int unres = Integer.parseInt(s.nextLine());
        int bcvac = Integer.parseInt(s.nextLine());
        int scvac = Integer.parseInt(s.nextLine());
        int stvac = Integer.parseInt(s.nextLine());
        for (int i = 0; i < num; i++) {
            String line = s.nextLine();
            String[] tokens = line.split(",");
            studentinfo eachstudentdata = new studentinfo(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
            students[i] = eachstudentdata;
        }
        Insertionsort insertion = new Insertionsort();
        insertion.sort(students);
        print(students);
        System.out.println();
        fillMerit(students, vac, unres, bcvac, scvac, stvac);
    }
	 public static void fillMerit(studentinfo[] list, int vac, int unres, int bc, int sc, int st) {
        for (int i = 0; i < list.length && vac > 0; i++) {
            if (unres > 0) {
                System.out.println(list[i].sname + "," +
                                   list[i].totalvals + "," +
                                   list[i].rescat);
                unres--;
            } else if (list[i].rescat.equals("BC") || list[i].rescat.equals("SC") || list[i].rescat.equals("ST")) {
                if (list[i].rescat.equals("BC") && bc > 0) {
                    System.out.println(list[i].sname + "," +
                                       list[i].totalvals + "," +
                                       list[i].rescat);
                    bc--;
                } else if (list[i].rescat.equals("SC") && sc > 0) {
                    System.out.println(list[i].sname + "," +
                                       list[i].totalvals + "," +
                                       list[i].rescat);
                    sc--;
                } else if (list[i].rescat.equals("ST") && st > 0) {
                    System.out.println(list[i].sname + "," +
                                       list[i].totalvals + "," +
                                       list[i].rescat);
                    st--;
                } else {
                }
            }
        }
        vac--;
    }
	 public static void print(studentinfo[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].sname + "," +
                               list[i].totalvals + "," +
                               list[i].rescat);
        }
    }

}