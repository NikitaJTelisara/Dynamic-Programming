public class DynamicProg {
    public static void main(String[] args) {
        fibonacci(6);
        computeSteps(6);
        computeCents(26);
        System.out.println("Factorial using Recursion :" + getFactorial(4)); /* recursion*/
        int[] m = new int[5];
        System.out.println("Factorial using DP :" + getFactorialDP(4, m));
        int res = getNbrOfPossiblePath(2, 3);
        System.out.println("No of possible paths :" + res);

        /* Magic Index */
        int[] arr = {0, 2, 3, 4, 5, 6, 7};
        res = getMagicIndexBad(arr);
        System.out.println("Magic Index Bad :" + res);
        res = getMagicIndexForDistinct(arr, 0, arr.length - 1);
        System.out.println("Magic Index For Distinct values :" + res);

        int[] arr1 = {1, 2, 2, 4, 4, 6, 7};
        res = getMagicIndexForNonDistinct(arr1, 0, arr1.length - 1);
        System.out.println("Magic Index For Non Distinct values :" + res);

        int[] arr2 = {1, 2, 2, 4};
        findNoOfSubsetDP(arr2);

    }


    public static void fibonacci(int n) {
        /* recursion */
        for (int i = 0; i < n; i++) {
            System.out.println(computeFibonacci(i));
        }

        /* dynamic program */
        System.out.println("dynamic program");
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m = computeDynamicFibonacci(i, m);
            System.out.println(m[i]);
        }
    }

    public static int computeFibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return (computeFibonacci(i - 1) + computeFibonacci(i - 2));
    }

    public static int[] computeDynamicFibonacci(int i, int[] map) {
        if (i == 0) {
            map[0] = 0;
        } else if (i == 1) {
            map[1] = 1;
        } else {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map;
    }

    /*9.1 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
    or 3 steps at a time. Implement a method to count how many possible ways the
    child can run up the stairs. */

    public static void computeSteps(int n) {
        /* recursion */
        int steps = computeStepsRecursive(n);
        System.out.println("Step prob");
        System.out.println(steps);
        n = n + 1;
        int[] m = new int[n];
        for (int i = 1; i < n; i++) {
            m = computeStepsDp(i, m);
        }
        System.out.println("Step dp prob");
        System.out.println(m[n - 1]);
    }

    public static int computeStepsRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        return computeStepsRecursive(n - 1) + computeStepsRecursive(n - 2) + computeStepsRecursive(n - 3);
    }
 
    public static int[] computeStepsDp(int i, int[] map) {
        if (i == 1) {
            map[1] = 1;
        } else if (i == 2) {
            map[2] = 2;
        } else if (i == 3) {
            map[3] = 3;
        } else {
            map[i] = map[i - 1] + map[i - 2] + map[i - 3];
        }
        return map;
    }

    /* 9.8 Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents)
 and pennies (1 cent), write code to calculate the number of ways of representing n
 cents.   */

    /* n cents = (n- 1 penny)
      n cents = (n- 1 nickel)
      n cents = (n- 1 dime)
      n cents = (n- 1 quarter)
    */
    public static void computeCents(int n) {
        // n = n + 1;
        int[] m = new int[n+1];

        System.out.println("Step dp prob");
        System.out.println(m);
    }

   /* public static int calculteCents(int n, int[] m) {
        if (n < 0) {
           return 0;
        } else if (m[n] == 0) {
            m[n] = 1;
        } else if (n > 4 && n < 10) {
            m[n] = 2;
        } else if (n > 9 && n < 15) {
            m[n] = 4;
        } else if (n > 14 && n < 20) {
            m[n] = 6;
        } else if (n > 19 && n < 25) {
            m[n] = 6;
        } else if (n == 25) {
            m[n] = 6;
        } else {
            m[n] = m[n - 25] + m[n - 10] + m[n - 5] + m[n - 1];
        }
        return m;
    } */

    /* 9.2 possible ways a robot can go from(0,0) -> (x,y) when it can walk only left and down */

    public static int getFactorial(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        return (n * getFactorial(n - 1));
    }
    /* not dp */
    public static int getFactorialDP(int n, int[] m) {
        if (n == 0) {
            m[0] = 1;
        }else if (n == 1) {
            m[1] = 1;
        } else if (n == 2) {
            m[2] = 2;
        }  else {
            m[n] = n * m[n-1];
        }
        return m[n];
    }

    public static int getNbrOfPossiblePath(int x, int y) {
        /* No of possibilities = (x+y)! / x!y!
         */
        int X = Math.abs(x);
        int Y = Math.abs(y);
        int Z = X + Y;
        return (getFactorial(Z) / (getFactorial(X) * getFactorial(Y)));
    }

    /* 9.3 A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] = i.
Given a sorted array of distinct integers, write a method to find a magic index, if
one exists, in array A. */

    public static int getMagicIndexBad(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }

    //arr -> 0,2,3,4,5,6,7
    //ind -> 0,1,2,3,4,5,6
    public static int getMagicIndexForDistinct(int[] arr, int low, int high) {
        int midInd = low + (high - low) / 2;
        if (midInd == arr[midInd]) {
            return midInd;
        } else if (arr[midInd] > midInd) {  // search left
            return (getMagicIndexForDistinct(arr, low, midInd - 1));
        } else {
            return (getMagicIndexForDistinct(arr, midInd + 1, high));  // search right
        }
    }

    //arr -> 2,2,3,4,4,6,7
    //ind -> 0,1,2,3,4,5,6
    public static int getMagicIndexForNonDistinct(int[] arr, int low, int high) {
        if (high < low) {
            return -1;
        }
        int midInd = low + (high - low) / 2;
        if (midInd == arr[midInd]) {
            return midInd;
        }
        int left = getMagicIndexForNonDistinct(arr, low, midInd - 1);
        int right = getMagicIndexForNonDistinct(arr, midInd + 1, high);
        if (left >= 0) {
            return left;
        }
        if (right >= 0) {
            return right;
        }
        return -1;
    }

    /* 9.4 Write a method to return all subsets of a set.  */

    /* for n elements , No of subset = 2^n.
    {1,2,3} has 2 subsets
     */

    public static void findNoOfSubsetDP(int[] arr) {
        int[] map = new int[arr.length + 1];
        int n = findNoOfSubset(arr.length);
        System.out.println("No of Subsets :" + n);

        n = findNoOfSubset(arr.length, map);
        System.out.println("No of Subsets with Dp :" + n);
    }

    /* recursion */
    public static int findNoOfSubset(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 2;
        }
        return (2 * findNoOfSubset(x - 1));
    }

    /* Dynamic Programming */
    public static int findNoOfSubset(int x, int[] m) {
        if (x == 1) {
            m[1] = 2;
            //return (m[x]);
        }
        if (m[x] == 0) {
            m[x] = 2 * findNoOfSubset(x - 1, m);
        }
        return m[x];
    }


    /* Permutation of n object
       P(n) = n!

       taken r at a time ,

       P(n,r)=n!/(n−r)!

     */

    /* Combination of n object
      C(n) = 1

      taken r at a time ,

      C(n,r)= n!/(n−r)!r!

      extra - Find union and intersection of 2 arrays
    */


}


