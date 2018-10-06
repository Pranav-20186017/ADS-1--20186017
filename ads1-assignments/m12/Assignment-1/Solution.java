import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
	static ArrayList<Student> students = new ArrayList<>();
	static ArrayList<Student> vaclist = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noLines = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int unres = Integer.parseInt(scan.nextLine());
		int bc = Integer.parseInt(scan.nextLine());
		int sc = Integer.parseInt(scan.nextLine());
		int st = Integer.parseInt(scan.nextLine());

		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			Student s = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
			students.add(s);
		}
		selectionSort();

		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).name + "," + students.get(i).tmarks + "," + students.get(i).rc);
		}
		System.out.println();

		fillVacancies(vacancies, unres, bc, sc, st);

	}
	public static void fillVacancies(int vacancies, int unres, int bc, int sc, int st) {
		int ucount = 0;
		int bcount = 0;
		int ccount = 0;
		int tcount = 0;
		int vcount = 0;
		for (int i = 0; i < students.size(); i++) {
			if(ucount == unres) break;
				vaclist.add(students.get(i));
				ucount++;
				vcount++;
			
		}
		for (int i = 0; i < students.size(); i++) {
			if(bcount == bc) break;
			if(students.get(i).rc.equals("BC")) {
				if(!vaclist.contains(students.get(i))) {
					vaclist.add(students.get(i));
					bcount++;
					vcount++;
				}
				
			}
			
		}
		for (int i = 0; i < students.size(); i++) {
			if(ccount == sc) break;
			if(students.get(i).rc.equals("SC")) {
				if(!vaclist.contains(students.get(i))) {

					vaclist.add(students.get(i));
					ccount++;
					vcount++;
				}
			}
			
		}
		//add st
		for (int i = 0; i < students.size(); i++) {
			if(tcount == st) break;
			if(students.get(i).rc.equals("ST")) {
				if(!vaclist.contains(students.get(i))) {
					vaclist.add(students.get(i));
					tcount++;
					vcount++;
				}
			}
			
		}
		for (int i = 0; i < students.size(); i++) {
			if(vcount == vacancies) break;
			if(!vaclist.contains(students.get(i))) {
				vaclist.add(students.get(i));
				vcount++;
			}
		}
		sortfinal();
		for (int i = 0; i < vaclist.size(); i++) {
			if( i == vacancies) break;
			System.out.println(vaclist.get(i).name + "," + vaclist.get(i).tmarks + "," + vaclist.get(i).rc);
		}
		

	}
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

}