import java.util.*;
class Common {
	int[] a;
	int[] b;
	int sizea = 0;
	int sizeb = 0;
	Common(int x, int y) {
		a = new int[x];
		b = new int[y];
	}
	void addToA(int val) {
		a[sizea] = val;
		sizea++;
	}
	void addToB(int val) {
		b[sizeb] = val;
		sizeb++;
	}
	String all() {
		Set<Integer> s = new TreeSet<Integer>();
		for (int i = 0 ; i < a.length; i++) {
			s.add(a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			s.add(b[i]);
		}
		String opt = "";
		for (Integer itr : s) {
			opt += itr + ",";
		}
		return opt.substring(0,opt.length()-1);
		
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = Integer.parseInt(s.nextLine());
		int y = Integer.parseInt(s.nextLine());
		Common c = new Common(x,y);
		String[] a = (s.nextLine().split(","));
		String[] b = (s.nextLine().split(","));
		int temp;
		for (int i = 0; i < a.length; i++) {
			temp = Integer.parseInt(a[i]);
			c.addToA(temp);
		}
		for (int i = 0; i < b.length; i++) {
			temp = Integer.parseInt(b[i]);
			c.addToB(temp);
		}
		System.out.println(c.all());
		
	}
}