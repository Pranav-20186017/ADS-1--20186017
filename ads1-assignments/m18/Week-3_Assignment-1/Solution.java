import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int five = 5;
        final int six = 6;
        int n = Integer.parseInt(scan.nextLine());
        BinarySearchST<String, Integer> maxs = new BinarySearchST<>();
        BinarySearchST<String, Integer> mins = new BinarySearchST<>();
        String[] line;
        int hours = six;
        while (hours > 0) {
            int k = n;
            MinPQ<Stock> globalmin = new MinPQ<Stock>();
            MaxPQ<Stock> globalmax = new MaxPQ<Stock>();
            while (k > 0) {
                line = scan.nextLine().split(",");
                globalmin.insert(new Stock(line[0], line[1]));
                globalmax.insert(new Stock(line[0], line[1]));
                k--;
            }
            int peak = five;
            while (peak > 0) {
                Stock s = globalmax.delMax();
                if (maxs.contains(s.name)) {
                    maxs.put(s.name, maxs.get(s.name) + 1);
                } else {
                    maxs.put(s.name, 1);
                }
                System.out.println(s.name + " " + s.val);
                peak--;
            }
            System.out.println();
            int low = five;
            while (low > 0) {
                Stock s = globalmin.delMin();
                if (mins.contains(s.name)) {
                    mins.put(s.name, mins.get(s.name) + 1);
                } else {
                    mins.put(s.name, 1);
                }
                System.out.println(s.name + " " + s.val);
                low--;
            }
            System.out.println();
            hours--;
        }
        int comms = Integer.parseInt(scan.nextLine());
        while (comms > 0) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "get" :
                if (tokens[1].equals("maxST")) {
                    if (maxs.contains(tokens[2])) {
                        System.out.println(maxs.get(
                            tokens[2]));
                    } else {
                        System.out.println("0");
                    }

                } else {
                    if (mins.contains(tokens[2])) {
                        System.out.println(mins.get(
                            tokens[2]));
                    } else {
                        System.out.println("0");
                    }
                }
                break;
            case "intersection" :
                int size1 = maxs.size();
                int size2 = mins.size();
                if (size2 > size1) {
                    for (String each : mins.keys()) {
                        if (maxs.contains(each)) {
                            System.out.println(each);
                        }
                    }
                } else {
                    for (String each : maxs.keys()) {
                        if (mins.contains(each)) {
                            System.out.println(each);
                        }
                    }
                }
                break;
                default :
            }
            comms--;
        }
    }
}
