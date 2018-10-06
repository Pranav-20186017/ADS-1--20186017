import java.util.Scanner;
// class Insertionsort() {

// }
class Student {
    String sname;
    String dob;
    int m1;
    int m2;
    int m3;
    int total;
    String rescat;
    String[] date;
    Student(String name, String age, int marks1, int marks2, int marks3, int sum, String res) {
        this.sname = name;
        this.dob = age;
        this.m1 = marks1;
        this.m2 = marks2;
        this.m3 = marks3;
        this.total = sum;
        this.rescat = res;
        this.date = dob.split("-");
    }
    public int compareTo(Student other) {
        if (this.total > other.total) {
            return 1;
        }
        if (this.total < other.total) {
            return -1;
        }
        if (this.m1 > other.m1) {
            return 1;
        }
        if (this.m2 > other.m2) {
            return 1;
        }
        if (this.m3 > other.m3) {
            return 1;
        }
        if (this.m1 < other.m1) {
            return -1;
        }
        if (this.m2 < other.m2) {
            return -1;
        }
        if (this.m3 < other.m3) {
            return -1;
        }
        if (Integer.parseInt(this.date[2]) > Integer.parseInt(other.date[2])) {
            return 1;
        }
        if (Integer.parseInt(this.date[1]) > Integer.parseInt(other.date[1])) {
            return 1;
        }
        if (Integer.parseInt(this.date[0]) > Integer.parseInt(other.date[0])) {
            return -1;
        }
         if (Integer.parseInt(this.date[2]) < Integer.parseInt(other.date[2])) {
            return -1;
        }
        if (Integer.parseInt(this.date[1]) < Integer.parseInt(other.date[1])) {
            return -1;
        }
        if (Integer.parseInt(this.date[0]) < Integer.parseInt(other.date[0])) {
            return -1;
        }
        return 0;
    }
}
class Solution {
    private Solution() {

    }
    public static void print() {

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int num = Integer.parseInt(s.nextLine());
            // Student[] student = new Student[num];
            int vac = Integer.parseInt(s.nextLine());
            int unreserved = Integer.parseInt(s.nextLine());
            int bcvac = Integer.parseInt(s.nextLine());
            int scvac = Integer.parseInt(s.nextLine());
            int stvac = Integer.parseInt(s.nextLine());
            for (int i = 0 ; i < num; i++) {
                String line = s.nextLine();
                String[] tokens = line.split(",");
                Student student = new Student(tokens[0],tokens[1],
                Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),
                Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]),
                tokens[6]);
            }
            // Insertionsort in = new Insertionsort();
            // in.sort();
            print();

        }

    }
}