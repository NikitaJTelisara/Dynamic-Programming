package Adobe;

import java.util.*;

public class findMissingNums {
    public static void main(String[] args) {
        int[] n = {3,3,4,4,5,5};

        List<Integer> res = findDisappearedNumbers(n);
        for (Integer k : res) {
              System.out.println(k);
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length > 0) {
            Integer min = nums[0];
            Integer max = nums[0];
            Set<Integer> s = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
                s.add(nums[i]);
            }
            for (int i = max; i >= min; i--) {
                if (!s.contains(i)) {
                    res.add(i);
                }
            }
            int needed = nums.length - s.size() - res.size();
            while (needed > 0 && min > 1) {
                res.add(min - 1);
                needed--;
                min--;
            }
            while (needed > 0) {
                res.add(max + 1);
                needed--;
                max++;
            }
        }
        return res;
    }
}
