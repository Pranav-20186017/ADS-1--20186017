import java.util.Scanner;
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
     * Determines if matching pair.
     *
     * @param      character1  The character 1
     * @param      character2  The character 2
     *
     * @return     True if matching pair, False otherwise.
     */
    static boolean isMatchingPair(final char character1,
    final char character2) {
       if (character1 == '(' && character2 == ')') {
         return true;
       } else if (character1 == '{' && character2 == '}') {
         return true;
       } else if (character1 == '[' && character2 == ']') {
         return true;
       } else {
         return false;
       }
    }
    /**
     * Determines if Parans are balanced.
     * @param exp character array.
     * @return boolean
     */
    static boolean areParenthesisBalanced(final char[] exp) {
       stack st = new stack();
       for (int i = 0; i < exp.length; i++) {
          if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
            st.push(exp[i]);
          }
          if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
             if (st.isEmpty()) {
                   return false;
               } else if (!isMatchingPair(st.pop(), exp[i])) {
                   return false;
               }
          }
       }
       if (st.isEmpty() == true) {
         return true;
       } else {
             return false;
         }
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        char[] exp;
        String string;
        for (int i = 0; i < n; i++) {
          string = s.nextLine();
          exp = string.toCharArray();
          if (areParenthesisBalanced(exp)) {
            System.out.println("YES");
          } else {
            System.out.println("NO");
          }
        }
    }
}