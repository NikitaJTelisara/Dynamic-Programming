package Adobe.maxAreaInMartrix;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char [][] m = {
                {'1','1','0'},
                {'1','1','0'},
                {'1','1','0'},
        };
        // return 6
        System.out.print(maximalRectangle(m));
    }

    public static int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0){
            return 0;
        }
        int[] temp = new int[matrix[0].length];
        int larhest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    temp[j] = 0;
                } else {
                    temp[j] = temp[j] + 1;
                }
            }
            larhest = Math.max(larhest, getMAxArea(temp, 0, temp.length - 1, 0));
        }
        return larhest;
    }

    public static int getMAxArea(int[] arr, int start, int end, int largest) {
        if (start > end) {
            return largest;
        } else {
            for (int i = start; i <= end; i++) {
                largest = Math.max(getHighestCommon(arr, i, end), largest);
            }
            for (int i = end; i >= start; i--) {
                largest = Math.max(getlowestCommon(arr, i, start), largest);
            }
            return Math.max(getMAxArea(arr, start + 1, end - 1, largest), largest);
        }
    }

    public static int getHighestCommon(int[] arr, int start, int end) {
        int largest = 0;
        int i = start;
        Stack s = new Stack();
        int min = 0;
        int count = 0;
        while (i <= end) {
            if (arr[i] == 0) {
                if (!s.isEmpty()) {
                    largest = Math.max(largest, min * count);
                }
                s = new Stack();
                count = 0;
            } else {
                if (s.isEmpty()) {
                    min = arr[i];
                }
                s.push(arr[i]);
                count++;
                min = Math.min(arr[i], min);
            }
            i++;
        }
        if (!s.isEmpty()) {
            largest = Math.max(largest, min * count);
        }
        return largest;
    }

    public static int getlowestCommon(int[] arr, int end, int start) {
        int largest = 0;
        int i = end;
        int count = 0;
        Stack s = new Stack();
        int min = 0;
        while (i >= start) {
            if (arr[i] == 0) {
                if (!s.isEmpty()) {
                    largest = Math.max(largest, min * count);
                }
                s = new Stack();
                count = 0;
            } else {
                if (s.isEmpty()) {
                    min = arr[i];
                }
                s.push(arr[i]);
                count++;
                min = Math.min(arr[i], min);
            }
            i--;
        }

        if (!s.isEmpty()) {
            largest = Math.max(largest, min * count);
        }
        return largest;
    }
}
