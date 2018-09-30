import java.util.Scanner;
/**
 * Class for deque.
 *
 * @param      <Item>  The item
 */
class Deque<Item> {
    Node first = null;
    Node last = null;
    int size = 0;
    class Node {
        Item data;
        Node next;
        Node(Item data) {
            this.data = data;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
    public void pushRight(Item element) {
        Node oldleft = last;
        last = new Node(element);
        if (isEmpty()) {
            first = last;
            last.next = null;
            size++;
            printList();
            return;
        }
        last.next = null;
        oldleft.next = last;
        size++;
        printList();
    }
    public void pushLeft(Item element) {
        Node oldright = first;
        first = new Node(element);
        if (isEmpty()) {
            last = first;
            size++;
            printList();
            return;

        }
        first.next = oldright;
        size++;
        printList();
    }
    public Item popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return null;
        }
        Item d = first.data;
        if (isEmpty()) {
            return null;
        }
        first = first.next;
        size--;
        printList();
        return d;
    }
    public Item popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return null;
        }
        Item d  =  last.data;
        if (isEmpty()) {
            return null;
        }
        int s = 0;
        Node get = first;
        while (s < size - 2) {
            get = get.next;
            s++;
        }
        last = get;
        size--;
        printList();
        return d;
    }
    public void printList() {
        if (size == 0) {
            System.out.println("[]");
            return;
        }
        Node tnode = first;
        String s = "";
        while (tnode != null) {
            s += tnode.data + ",";
            tnode = tnode.next;
        }
        String[] str = s.split(",");
        String pr = "[";
        for(int i = 0;i<size-1;i++) {
            pr += str[i] + ", ";
        }
        pr += str[size-1] + "]";
        System.out.println(pr);
    }
}
/**
 * Class for solution.
 */
final class Solution {
    private Solution() {
        //unused.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> q = new Deque<>();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                q.pushLeft(Integer.parseInt(line[1]));
                break;
            case "pushRight":
                q.pushRight(Integer.parseInt(line[1]));
                break;
            case "popRight":
                q.popRight();
                break;
            case "popLeft":
                q.popLeft();
                break;
            case "size":
                System.out.println(q.getSize());
                break;
            default :
            }
        }

    }
}