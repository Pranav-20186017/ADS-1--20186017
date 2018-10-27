import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * variable for student name.
     */
    private String studentname;
    /**
     * varibale for student marks.
     */
    private double totalmarks;
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String name, final double marks) {
        this.studentname = name;
        this.totalmarks = marks;
    }
    /**
     * fetches the name of the student.
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return this.studentname;
    }
    /**
     * fetches the marks of the student.
     *
     * @return     { description_of_the_return_value }
     */
    public double getmarks() {
        return this.totalmarks;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = str + this.studentname + this.totalmarks;
        return str;
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
        Scanner scan = new Scanner(System.in);
        int putnumber = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<Integer, Student> chainobj
        = new SeparateChainingHashST<>();
        for (int i = 0; i < putnumber; i++) {
            String[] tokens = scan.nextLine().split(",");
            Student stobj
            = new Student(tokens[1], Double.parseDouble(tokens[2]));
            chainobj.put(Integer.parseInt(tokens[0]), stobj);
        }
        int querynum = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < querynum; j++) {
            String[] query = scan.nextLine().split(" ");
            if (query[0].equals("get")) {
                if (Integer.parseInt(query[2]) == 1) {
                    if (chainobj.get(Integer.parseInt(query[1]))
                        == null) {
                        System.out.println("Student doesn't exists...");
                    } else {
                        System.out.println(
                            chainobj.get(
                                Integer.parseInt(query[1])).getname());
                    }

                } else {
                    if (chainobj.get(Integer.parseInt(query[1])) == null) {
                        System.out.println("Student doesn't exists...");
                    } else {
                        System.out.println(
                            chainobj.get(
                                Integer.parseInt(query[1])).getmarks());
                    }
                }
            }
        }
    }
}
