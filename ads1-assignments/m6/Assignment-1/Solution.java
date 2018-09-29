// import java.util.Scanner;
import java.util.*;
class LinkedList {
    Node first = null;
    class Node {
        int data;
        Node next;
        int size;
        Node(int input) {
            this.data = input;
        }
    }
    void push(int item) {
        Node newnode = new Node(item);
        newnode.next = first;
        first = newnode;
    }
    int pop() {
        int opt = first.data;
        first = first.next;
        return opt;
    }
    String print() {
        Node temp = first;
        String val = "";
        while(temp != null) {
            val = val + temp.data;
            temp = temp.next;
        }
        return val;
    }
    int getsize() {
        Node temp = first;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

}
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
        LinkedList values = new LinkedList();
        for(int i = number.length() - 1; i >= 0; i--) {
            String element = "" + number.charAt(i);
            values.push(Integer.parseInt(element));
        }
        return values;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.print();
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    //     Stack<Integer> s1 = new Stack<Integer>();
    //     Stack<Integer> s2 = new Stack<Integer>();
    //     String one = list1.print();
    //     String two = list2.print();
    //     System.out.println(one);
    //     System.out.println(two);
    //     for (int i = 0; i < one.length(); i++) {
    //         String t = one.charAt(i);
    //         int temp = Integer.parseInt(t);
    //         s1.push(temp);
    //     }
    //     for (int i = 0; i < two.length(); i++) {
    //         String t = two.charAt(i);
    //         int temp = Integer.parseInt(t);
    //         s2.push(temp);
    //     }
    //     return null;
    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}