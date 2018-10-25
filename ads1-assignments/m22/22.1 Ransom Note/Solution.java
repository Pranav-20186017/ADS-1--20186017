import java.util.Scanner;
/**
 * Class for solution.
 */
final  class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**.
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable ht = new HashTable();
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        String line = sc.nextLine();
        String[] tokens1 = line.split(" ");
        for (int i = 0; i < tokens1.length; i++) {
            if (ht.contains(tokens1[i])) {
                ht.put(tokens1[i], ht.get(tokens1[i]) + 1);
            } else {
                ht.put(tokens1[i], 1);
            }
        }
        String line2 = sc.nextLine();
        String[] tokens2 = line2.split(" ");
        int[] array = new int[tokens2.length];
        for (int i = 0; i < tokens2.length; i++) {
            int value = ht.get(tokens2[i]);
            if (ht.contains(tokens2[i])) {
                array[i] = --value;
                ht.put(tokens2[i], value);
            } else {
                array[i] = value;
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
                break;
            } else {
                count = 0;
            }
        }
        if (count == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}