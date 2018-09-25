class Percolation {
    boolean[][] opened;
    int top = 0;
    int bottom;
    int size;
    UF uf;
    int count = 0;

    public Percolation(int N) {
        opened = new boolean[N][N];
        size = N;
        bottom = N * N + 1;
        uf = new UF(N * N + 2);
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) return;
        count++;
        opened[row - 1][col - 1] = true;
        if (row == 1)
            uf.union(top, getUFIndex(row, col));
        if (row == size)
            uf.union(getUFIndex(row, col), bottom);
        if (row > 1 && isOpen(row - 1, col))
            uf.union(getUFIndex(row, col), getUFIndex(row - 1, col));
        if (row < size && isOpen(row + 1, col))
            uf.union(getUFIndex(row, col), getUFIndex(row + 1, col));
        if (col > 1 && isOpen(row, col - 1))
            uf.union(getUFIndex(row, col), getUFIndex(row, col - 1));
        if (col < size && isOpen(row, col + 1))
            uf.union(getUFIndex(row, col), getUFIndex(row, col + 1));
    }

    public boolean isOpen(int row, int col) {
        return opened[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        return uf.connected(top, getUFIndex(row, col));
    }

    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    private int getUFIndex(int row, int col) {
        return size * (row - 1) + col;
    }
}