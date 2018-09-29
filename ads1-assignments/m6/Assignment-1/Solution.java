import java.util.Scanner;
class LinkedList {
    Node first = null;
    class Node {
    int data;
    Node next;
    Node(int input) {
        this.data = input;
        }
    }
    void push(int ptr) {
        Node newnode = new Node(ptr);
        newnode.next = first;
        first = newnode;
    }
    int pop() {
        int output = first.data;
        first = first.next;
        return output;
    }
    String print() {
        Node temp = first;
        String num = "";
        while(temp != null) {
            num = num + temp.data;
            temp = temp.next;
        }
        return num;

        }
    }
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        for (int i = 0; i< number.length(); i++) {
            String num = "" + number.charAt(i);
            l.push(Integer.parseInt(num));
        }
        return l;

    }

    public static String digitsToNumber(LinkedList list) {
        return list.print();

    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

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
            //     LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            //     LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}
