package Adobe;

public class WaterCount {
    public static void main(String[] args) {
        int[] n = {5, 2, 1, 2, 1, 5};
        System.out.println(waterCountIter(n));
        System.out.println(waterCountRec(n, 0));
    }

    public static int getCountFromOneRow(int[] arr) {
        boolean found1 = false;
        int count = 0;
        int finalCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && found1 == false) {
                found1 = true;
            }
            if (arr[i] == 0 && found1 == true) {
                count++;
            }
            if (arr[i] == 1 && found1 == true) {
                finalCount = finalCount + count;
                count = 0;
            }
        }
        return finalCount;
    }

    public static int waterCountRec(int[] height, int waterC) {
        int largest = 0;
        for (int i = 0; i < height.length; i++) {
            largest = Math.max(largest, height[i]);
        }
        if (largest > 0) {
            int[] temp = new int[height.length];
            int[] nextTemp = new int[height.length];
            for (int i = 0; i < height.length; i++) {
                temp[i] = (height[i] == 0 ? 0 : 1);
                nextTemp[i] = (height[i] == 0 ? 0 : height[i] - 1);
            }

            for (int kk : nextTemp) {
                System.out.print(kk);
            }
            System.out.print("\n");
            waterC = waterC + getCountFromOneRow(temp);
            return waterCountRec(nextTemp, waterC);
        } else {
            return waterC;
        }
    }

    public static int waterCountIter(int[] arr) {
        int waterC = 0;
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int[][] m = new int[largest][arr.length];
        for (int i = 0; i < largest; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 0) {
                    m[i][j] = 0;
                } else {
                    m[i][j] = 1;
                    arr[j] = arr[j] - 1;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            waterC += getCountFromOneRow(m[i]);
        }
        return waterC;
    }
}
