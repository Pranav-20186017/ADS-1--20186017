import java.util.Scanner;
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

   public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList carry = new LinkedList();
        final int ten = 10;
        final int nine = 9;
        carry.push(0);
        if (list1.size() <= list2.size()) {
            int out = 0;
            String result = "";
            while (!list1.isEmpty()) {
                out = carry.pop()
                      + list1.newpop(list1.size)
                      + list2.newpop(list2.size);
                result =  (out % ten) + result;
                if (out > nine) {
                    carry.push(out / ten);
                } else {
                    carry.push(0);
                }
            }
            while (!list2.isEmpty()) {
                result =  list2.newpop(list2.size) + carry.pop() + result;
                carry.push(0);
            }
            if (carry.first.data != 0) {
                result = carry.pop() + result;
            }
            return numberToDigits(result);
        } else {
            int out = 0;
            String result = "";
            while (!list2.isEmpty()) {
                out = carry.pop()
                      + list1.newpop(list1.size)
                      + list2.newpop(list2.size);
                result = result + (out % ten);
                if (out > nine) {
                    carry.push(out / ten);
                }
            }
            while (!list1.isEmpty()) {
                result = result + list1.newpop(list1.size) + carry.pop();
                carry.push(0);
            }
            return numberToDigits(result);
        }
    }
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

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}