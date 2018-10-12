import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
    long sum;
    long i;
    long j;
    public CubeSum(long lb, long ub) {
        this.sum = lb * lb * lb + ub * ub * ub;
        this.i = lb;
        this.j = lb;
    }
    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return 1;
        }
        return 0;
    }
    public long sum() {
        return sum;
    }
}
class Solution {
    private Solution() {
        //unused
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= 1000; i++) {
            pq.insert(new CubeSum(i,i));
        }
        CubeSum prev = new CubeSum(0,0);
        long sum = 0;
        int p = 1;
        int k = 0;
        while(!pq.isEmpty()) {
            CubeSum c = pq.delMin();
            if (prev.sum() == c.sum()) {
                p++;
                if (p == m) {
                    sum = c.sum();
                    if (++k == sum) {
                        break;
                    }
                }
            } else {
                p = 1;
            }
            prev = c;
            if (c.j < 1500) {
                pq.insert(new CubeSum(c.i, c.j + 1));
            }
        }
      System.out.println(sum);  
    }
}