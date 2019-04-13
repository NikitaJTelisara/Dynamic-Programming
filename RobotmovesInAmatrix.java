public class RobotmovesInAmatrix {
    public static void main(String[] args) {
        System.out.println(uniquePathsWhenStartIs11(36, 7));
        System.out.println(uniquePathsWhenStartIs00(36, 7));
    }

    public static int uniquePathsWhenStartIs11(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }
        return (uniquePathsWhenStartIs11(m - 1, n) + uniquePathsWhenStartIs11(m, n - 1));
    }

    public static int uniquePathsWhenStartIs00(int m, int n) {
        m = m - 1;
        n = n - 1;
        if (m == 0 || n == 0) {
            return 1;
        }
        /*
          (m + y)!   / (m!*n!)
          (3+2)! / (3! * 2!)
           10*9!/12
         */
        return (getFact(m + n) / (getFact(m) * getFact(n)));
    }

    public static int getFact(int m) {
        if (m == 1) {
            return 1;
        }
        return m * getFact(m - 1);
    }
}