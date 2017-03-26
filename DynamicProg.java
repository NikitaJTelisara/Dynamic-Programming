public class DynamicProg {
    public static void main(String[] args) {
        fibonacci(6);
        computeSteps(6);
        //computeCents(26);
        System.out.println(getFactorial(5)); /* recursion*/
        /* int[] m = new int[1];
     int a = getFactorialDP(1, m);
     System.out.println(a);   */
        int res = getNbrOfPossiblePath(2, 3);
        System.out.print("No of possible paths :" + res);
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
    /* public static void computeCents(int n) {
      // n = n + 1;
      int[] m = new int[n];
      for (int i = 1; i < n; i++) {
          m = calculteCents(n, m);
      }
      System.out.println("Step dp prob");
      System.out.println(m);
  }

  public static int[] calculteCents(int n, int[] m) {
      if (n < 0) {
          m[n] = 0;
      } else if (n > 0 && n < 5) {
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
  }  */

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

    /*public static int getFactorialDP(int n, int[] m) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (m[n] != 0) {
            return m[n];
        } else {
            m[n] = n * getFactorialDP(n - 1, m);
            return m[n];
        }
    }*/

    public static int getNbrOfPossiblePath(int x, int y) {
        /* No of possibilities = (x+y)! / x!y!
         */
        int X = Math.abs(x);
        int Y = Math.abs(y);
        int Z = X + Y;
        return (getFactorial(Z) / (getFactorial(X) * getFactorial(Y)));
    }

}

