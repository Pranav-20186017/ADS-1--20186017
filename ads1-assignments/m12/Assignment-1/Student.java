class Student implements Comparable<Student> {
	String name;
	int m1;
	int m2;
	int m3;
	int total;
	String rescat;
	int day;
	int month;
	int year;

	Student(String name, String dob, String m1, String m2, String m3, String total, String rescat) {
		this.name = name;
		String[] d = dob.split("-");
		this.day = Integer.parseInt(d[0]);
		this.month = Integer.parseInt(d[1]);
		this.year = Integer.parseInt(d[2]);
		this.m1 = Integer.parseInt(m1);
		this.m2 = Integer.parseInt(m2);
		this.m3 = Integer.parseInt(m3);
		this.total = Integer.parseInt(total);
		this.rescat = rescat;

	}
	public int compareTo(Student other) {
		if (this.total > other.total) return 1;
		if (this.total < other.total) return -1;
		if (this.m3 > other.m3) return 1;
		if (this.m3 < other.m3) return -1;
		if (this.m2 > other.m2) return 1;
		if (this.m2 < other.m2) return -1;
		if (this.year > other.year) return 1;
		if (this.year < other.year) return -1;
		if (this.month > other.month) return 1;
		if (this.month < other.month) return -1;
		if (this.day < other.day) return 1;
		if (this.day > other.day) return -1;
		

		return 0;
	}
	public int compare(Student other) {
		if((this.rescat.equals("SC") || this.rescat.equals("ST") || this.rescat.equals("BC") && other.rescat.equals("Open"))) {
			return 1;
		}
		if((other.rescat.equals("SC") || other.rescat.equals("ST") || other.rescat.equals("BC") && this.rescat.equals("Open"))) {
			return -1;
		}
		
		return 0;
	}
}