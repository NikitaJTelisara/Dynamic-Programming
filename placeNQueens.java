class placeNQueens {
    public static void main(String[] args) {
        int[][] m = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        printBoard(m);
        placeQueens(m);
        System.out.println("Queen placed");
        printBoard(m);

        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};
        printBoard(m1);
        placeQueens(m1);
        System.out.println("Queen placed");
        printBoard(m1);
    }
    /* mark as 1 where queen is placed */

    public static void placeQueens(int[][] m) {
        boolean[] rows = new boolean[m.length];
        boolean[] cols = new boolean[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (!rows[i] && !cols[j]) {
                    if (isDiagonalSafe(m, i, j)) {
                        m[i][j] = 1;
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }
        }
    }

    public static boolean isDiagonalSafe(int[][] m, int row, int col) {
        int i = row;
        int j = col;
        while (i >= 0 && i < m.length && j >= 0 && j < m.length) {
            if (m[i][j] == 1) {
                return false;
            } else {
                i++;
                j++;
            }
        }

        i = row;
        j = col;
        while (i >= 0 && i < m.length && j >= 0 && j < m.length) {
            if (m[i][j] == 1) {
                return false;
            } else {
                i--;
                j--;
            }
        }
        i = row;
        j = col;
        while (i >= 0 && i < m.length && j >= 0 && j < m.length) {
            if (m[i][j] == 1) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        i = row;
        j = col;
        while (i >= 0 && i < m.length && j >= 0 && j < m.length) {
            if (m[i][j] == 1) {
                return false;
            } else {
                i--;
                j++;
            }
        }
        return true;
    }

    public static void printBoard(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + ",");
            }
            System.out.print("\n");
        }
    }
}
