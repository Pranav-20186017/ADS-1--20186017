/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList vals = new LinkedList();
        for(int i = number.length() - 1; i >= 0; i--) {
            String element = "" + number.charAt(i);
            vals.push(Integer.parseInt(element));
        }
        return vals;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.print();
    }

   public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList carry = new LinkedList();
        carry.push(0);
        if (list1.size() <= list2.size()) {
            int output = 0;
            String answer = "";
            while (!list1.isEmpty()) {
                output = carry.pop()+ list1.newpop(list1.size) + list2.newpop(list2.size);
                answer =  (output % 10) + answer;
                if (output > 9) {
                    carry.push(output / 10);
                } else {
                    carry.push(0);
                }
            }
            while (!list2.isEmpty()) {
                answer =  list2.newpop(list2.size) + carry.pop() + answer;
                carry.push(0);
            }
            if (carry.first.data != 0) {
                answer = carry.pop() + answer;
            }
            return numberToDigits(answer);
        } else {
            int output = 0;
            String answer = "";
            while (!list2.isEmpty()) {
                output = carry.pop()
                      + list1.newpop(list1.size)
                      + list2.newpop(list2.size);
                answer = answer + (output % 10);
                if (output > 9) {
                    carry.push(output / 10);
                }
            }
            while (!list1.isEmpty()) {
                answer = answer + list1.newpop(list1.size) + carry.pop();
                carry.push(0);
            }
            return numberToDigits(answer);
        }
    }
}
