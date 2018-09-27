import java.util.Scanner;
public class Solution  
{ 
    static boolean isMatchingPair(char character1, char character2) 
    { 
       if (character1 == '(' && character2 == ')') {
         return true; 
       }
       else if (character1 == '{' && character2 == '}') {
         return true; 
       }
       else if (character1 == '[' && character2 == ']') {
         return true; 
       }
       else {
         return false; 
       }
    } 
    static boolean areParenthesisBalanced(char exp[]) 
    { 
       stack st = new stack(); 
       for(int i=0;i<exp.length;i++) 
       { 
          if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
            st.push(exp[i]); 
          }
          if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') { 
             if (st.isEmpty()) { 
                   return false; 
               } else if (!isMatchingPair(st.pop(), exp[i]) ) { 
                   return false; 
               } 
          } 
            
       } 
       if (st.isEmpty()) {
         return true;
       }
       else {
             return false; 
         }  
    }  
    public static void main(final String[] args)  { 
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        char[] exp;
        String string;
        for(int i = 0; i < n; i++) {
          string = s.nextLine();
          exp = string.toCharArray();
          if (areParenthesisBalanced(exp)) 
            System.out.println("YES");
          else
            System.out.println("NO");  
        }  
    } 
  
} 