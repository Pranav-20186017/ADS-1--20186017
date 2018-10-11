import java.util.Scanner;
class BinarySearchTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private int size;

    private class Node {
        private BookList key;
        private Value val;
        private Node left, right;

        public Node () {
        }
    }

    public void put(BookList key, Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }

    public Node put(Node head, BookList key, Value val) {
        if (head == null) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            node.left = node.right = null;
            head = node;
            size++;
        }
        int compare = key.compareTo(head.key);
        if (compare < 0) {
            head.left  = put(head.left, key, val);
        } else if (compare > 0) {
            head.right = put(head.right, key, val);
        } else {
            head.val = val;
        }
        return head;
    }

    public Value get(BookList key) {
        return get(root, key);
    }

    private Value get(Node root, BookList key) {
        if (key == null) {
            System.out.println("key is null");
        }
        
        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return get(root.left, key);
        } else if (compare > 0) {
            return get(root.right, key);
        } else{
            return root.val;
        }
    }
}
class BookList<Key extends Comparable<Key>,Value> {
    String name;
    String author;
    Float cost;

    BookList(String name, String author, Float cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int compareTo(BookList that) {
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        } else {
            if (this.getAuthor().compareTo(that.getAuthor()) > 0) {
                return 1;
            } else if (this.getAuthor().compareTo(that.getAuthor()) < 0) {
                return -1;
            } else {
                if (this.getCost() > that.getCost()) {
                    return 1;
                } else if (this.getCost() < that.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
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
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
                case "put":
                    bst.put(new BookList(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
                case "get":
                    System.out.println(bst.get(new BookList(tokens[1],
                        tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
                default:
                break;
            }
        }
    }
}