import java.util.Scanner;
/**
 * Class for insertion sort.
 */
class Insertionsort {
    /**
     * exchanges the elements of an array.
     * @param      list  The list
     * @param      lo    The lower
     * @param      hi    The higher
     */
    void exchange(final Studentinfo[] list, final int lo, final int hi) {
        Studentinfo temp = list[lo];
        list[lo] = list[hi];
        list[hi] = temp;
    }
    /**
     * returns the boolean value for the comparison of two objects.
     *
     * @param      one   One
     * @param      two   Two
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final Studentinfo one, final Studentinfo two) {
        return one.compareTo(two) == -1;
    }
    /**
     * sort the elements.
     * Time Complexity - O(N^2) - Average Case and Worst Case.
     * Time Complexity - Omega(N) - Best Case.
     *
     * @param      students  The students
     */
    void sort(final Studentinfo[] students) {
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
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        Scanner s =  new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        Studentinfo[] students = new Studentinfo[num];
        int vac = Integer.parseInt(s.nextLine());
        int unres = Integer.parseInt(s.nextLine());
        int bcvac = Integer.parseInt(s.nextLine());
        int scvac = Integer.parseInt(s.nextLine());
        int stvac = Integer.parseInt(s.nextLine());
        for (int i = 0; i < num; i++) {
            String line = s.nextLine();
            String[] tokens = line.split(",");
            Studentinfo eachstudentdata = new Studentinfo(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[three]),
                    Integer.parseInt(tokens[four]),
                    Integer.parseInt(tokens[five]), tokens[six]);
            students[i] = eachstudentdata;
        }
        Insertionsort insertion = new Insertionsort();
        insertion.sort(students);
        print(students);
        System.out.println();
        fillMerit(students, vac, unres, bcvac, scvac, stvac);
    }
    /**
     * fill the merit list with students.
     *
     * @param      list   The list.
     * @param      vacant    The vacancies.
     * @param      unreserved  The unreserved seats.
     * @param      back     The bc quota seats.
     * @param      sec     The sc quota seats
     * @param      set     The st quota seats.
     */
     public static void fillMerit(final Studentinfo[] list, final int vacant,
        final int unreserved, final int back,
        final int sec, final int set) {
        int vac = vacant;
        int unres = unreserved;
        int bc = back;
        int sc = sec;
        int st = set;
        for (int i = 0; i < list.length && vac > 0; i++) {
            if (unres > 0) {
                System.out.println(list[i].sname + ","
                                   + list[i].totalvals + ","
                                   + list[i].rescat);
                unres--;
            } else if (list[i].rescat.equals("BC")
                || list[i].rescat.equals("SC")
                || list[i].rescat.equals("ST")) {
                if (list[i].rescat.equals("BC") && bc > 0) {
                    System.out.println(list[i].sname + ","
                                       + list[i].totalvals + ","
                                       + list[i].rescat);
                    bc--;
                } else if (list[i].rescat.equals("SC") && sc > 0) {
                    System.out.println(list[i].sname + ","
                                       + list[i].totalvals + ","
                                       + list[i].rescat);
                    sc--;
                } else if (list[i].rescat.equals("ST") && st > 0) {
                    System.out.println(list[i].sname + ","
                                       + list[i].totalvals + ","
                                       + list[i].rescat);
                    st--;
                }
            }
        }
        vac--;
    }
    /**
     * print the detials of the students.
     *
     * @param      list  The list of student objects
     */
     public static void print(final Studentinfo[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].sname + ","
                               + list[i].totalvals + ","
                               + list[i].rescat);
        }
    }
}
