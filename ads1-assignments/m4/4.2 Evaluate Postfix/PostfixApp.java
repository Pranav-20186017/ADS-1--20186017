import java.util.*;
class StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;
    public StackX(int size) {
        maxSize =size;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int j) {
        stackArray[++top] = j;
    }
    public int pop() {
        return stackArray[top--];
    }
}
class ParsePost {
    private StackX theStack;
    private String input;
    public ParsePost(String s) {
        input = s;
    }
    public int doParse() {
        theStack = new StackX(1000);
        char ch;
        int j;
        int num1, num2, interAns;
        for(j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            if (ch >= '0' && ch <= '9') {
                theStack.push((int) ch - '0');
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch(ch) {
                    case '+' : interAns = num1 + num2;
                               break;
                    case '-' : interAns = num1 - num2;
                                break;
                    case '*' : interAns = num1 * num2;
                               break;
                    case '/' : interAns = num1 / num2;
                               break;
                    default  : interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}
class PostfixApp {
    public static void main(String[] args) {
        String input;
        int output;
        Scanner s = new Scanner(System.in);
        input = s.nextLine().replaceAll(" ","");
        ParsePost aParser = new ParsePost(input);
        output = aParser.doParse();
        System.out.println(output);
    }
}