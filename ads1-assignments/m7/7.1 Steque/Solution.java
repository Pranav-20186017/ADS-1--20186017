import java.util.Scanner;
class Solution {
    private Solution() {
    	//unused constructor.
    }
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] tokens;
        String word = "";
        LinkedList linkedlist;
        while (n > 0) {
            linkedlist = new LinkedList();
            while (s.hasNext()) {
                word = s.nextLine();
                if (word.isEmpty()) {
                    break;
                }
                tokens = word.split(" ");
                switch (tokens[0]) {
                case "push":
                    linkedlist.push(Integer.parseInt(tokens[1]));
                    System.out.println(linkedlist.print());
                    break;
                case "enqueue":
                    linkedlist.enqueue(Integer.parseInt(tokens[1]));
                    System.out.println(linkedlist.print());
                    break;
                case "pop":
                    if (!(linkedlist.isEmpty())) {
                        linkedlist.pop();
                    }
                    System.out.println(linkedlist.print());
                    break;
                default :
                    break;
                }
            }
            n--;
            System.out.println();
        }
    }
}
