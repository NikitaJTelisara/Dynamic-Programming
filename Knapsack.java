public class Knapsack {
    public static void main(String[] args) {
        //3 items
        // Value = 10, 4 ,7
        // Weight = 4,2,3
        //Capacity Weight = 5 kgs

        /*

        v   W  0,  1,  2  ,3  ,4,  5

        4,  2, 0   0,  4  ,4   4   4
        7,  3, 0   0,  4,  7   7    7
        10, 4, 0,  0,  0  ,0,   10   10

        x1  x2  x3
        1    1   0


        V[i,w]  = max {V[i-1,w]  , V[i-1,  w- w[i]] + v[i]}

        V[2,4] = max (V[1,4],  V[1, 4- 4 ] + 10]
                    max{ 7,0+10} = 10
         */

         int[] w = {2,3,4};
        int[] val ={4,7,10};
         int k = knapSack(5,w,val,3);
         System.out.println(k);
    }

    public static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int[][] K = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max((val[i-1] + K[i-1][w-wt[i-1]]),  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }
}
