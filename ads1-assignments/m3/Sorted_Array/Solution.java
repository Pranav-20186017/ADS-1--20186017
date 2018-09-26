import java.util.Scanner;
/**SORTARRAY.**/
final class Solution {
    /**
     * Solution.
     */
    private Solution() { }
    /**
     * @param args [description]
     */
    public static void main(final String[] args) {
    Scanner s = new Scanner(System.in);
    String s1 = s.nextLine();
    String s2 = s.nextLine();
    int num1 = Integer.parseInt(s1);
    int num2 = Integer.parseInt(s2);
    int total = num1 + num2;
    String[] token = s.nextLine().split(",");
    int[] a = new int[num1];
    int[] b = new int[num2];
    if (num1 > 0) {
    for (int i = 0; i < token.length; i++) {
        a[i] = Integer.parseInt(token[i]);
    }
}
    if (num2 > 0) {
    String[] tokens = s.nextLine().split(",");
    for (int j = 0; j < tokens.length; j++) {
        b[j] = Integer.parseInt(tokens[j]);
    }
}
    int[] c = new int[total];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < num1 && j < num2) {
        if (a[i] < b[j]) {
            c[k] = a[i];
            i++;
            k++;
        } else {
            c[k] = b[j];
            k++;
            j++;

        }

    }
    while (j < num2) {
        c[k] = b[j];
        k++;
        j++;
    }
    while (i < num1) {
        c[k] = a[i];
        k++;
        i++;
    }
    //System.out.println(total);
    //System.out.println(Arrays.toString(token));
    for (int l = 0; l < c.length - 1; l++) {
        System.out.print(c[l] + ",");
     }
     System.out.print(c[c.length - 1]);
    }
    }
