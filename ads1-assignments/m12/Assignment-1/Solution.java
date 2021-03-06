import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * list for vacancies.
     */
    static ArrayList<Student> vaclist = new ArrayList<>();
    /**
     * list for students.
     */
    static ArrayList<Student> students = new ArrayList<>();
    /**
     * fills the seats by merit.
     *
     * @param      vacancies  The vacancies
     * @param      unres      The unres
     * @param      bc         { parameter_description }
     * @param      sc         The screen
     * @param      st         { parameter_description }
     */
    public static void meritFill(final int vacancies,
        final int unres, final int bc, final int sc, final int st) {
        int ucount = 0;
        int bcount = 0;
        int ccount = 0;
        int tcount = 0;
        int vcount = 0;
        for (int i = 0; i < students.size(); i++) {
            if (ucount == unres) {
                break;
            }
                vaclist.add(students.get(i));
                ucount++;
                vcount++;
        }
        for (int i = 0; i < students.size(); i++) {
            if (bcount == bc) {
                break;
            }
            if (students.get(i).rescat.equals("BC")) {
                if (!vaclist.contains(students.get(i))) {
                    vaclist.add(students.get(i));
                    bcount++;
                    vcount++;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (ccount == sc) {
                break;
            }
            if (students.get(i).rescat.equals("SC")) {
                if (!vaclist.contains(students.get(i))) {
                    vaclist.add(students.get(i));
                    ccount++;
                    vcount++;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (tcount == st) {
                break;
            }
            if (students.get(i).rescat.equals("ST")) {
                if (!vaclist.contains(students.get(i))) {
                    vaclist.add(students.get(i));
                    tcount++;
                    vcount++;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (vcount == vacancies) {
                break;
            }
            if (!vaclist.contains(students.get(i))) {
                vaclist.add(students.get(i));
                vcount++;
            }
        }
        sortfinal();
        for (int i = 0; i < vaclist.size(); i++) {
            if (i == vacancies) {
                break;
            }
            System.out.println(vaclist.get(i).name
                + "," + vaclist.get(i).total + ","
                + vaclist.get(i).rescat);
        }
    }
    /**
     * sorts the data one last time.
     */
    public static void sortfinal() {
        for (int i = vaclist.size() - 1; i >= 0; i--) {
            Student max = vaclist.get(i);
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(vaclist.get(j)) == 1) {
                    max = vaclist.get(j);
                    index = j;
                }
            }
            Student temp = vaclist.get(i);
            vaclist.set(i, max);
            if (index != -1) {
                vaclist.set(index, temp);
            }
        }
    }
    /**
     * Sorting using selection sort.
     */
    public static void selectionSort() {
        for (int i = students.size() - 1; i >= 0; i--) {
            Student max = students.get(i);
            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(students.get(j)) == 1) {
                    max = students.get(j);
                    index = j;
                }
            }
            Student temp = students.get(i);
            students.set(i, max);
            if (index != -1) {
                students.set(index, temp);
            }
        }
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int vacancies = Integer.parseInt(scanner.nextLine());
        int unres = Integer.parseInt(scanner.nextLine());
        int bc = Integer.parseInt(scanner.nextLine());
        int sc = Integer.parseInt(scanner.nextLine());
        int st = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split(",");
            Student s = new Student(tokens[0], tokens[1],
                tokens[2], tokens[three], tokens[four],
                tokens[five], tokens[six]);
            students.add(s);
        }
        selectionSort();
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).name
                + "," + students.get(i).total
                + "," + students.get(i).rescat);
        }
        System.out.println();
        meritFill(vacancies, unres, bc, sc, st);
    }

}
