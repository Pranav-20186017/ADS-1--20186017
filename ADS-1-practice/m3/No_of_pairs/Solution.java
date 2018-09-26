import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		int c = 1;
		int total = 0;
		int initial = a[0];
		for(int i = 1 ; i < n; i++) {
			if(initial == a[i]) {
				c++;
			}
			else {
				total+= c*(c - 1)/2;
				initial = a[i];
				c = 1;
			}

		}
		total = total + c*(c-1)/2;
		System.out.println(total);
	}
}