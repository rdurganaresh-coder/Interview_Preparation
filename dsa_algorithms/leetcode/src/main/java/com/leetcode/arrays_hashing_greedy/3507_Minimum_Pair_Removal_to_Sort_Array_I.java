package com.leetcode.arrays_hashing_greedy;

class Solution3507 {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int x : nums) {
            arr.add(x);
        }
        int ans = 0;
        while (!isNonDecreasing(arr)) {
            int k = 0;
            int s = arr.get(0) + arr.get(1);
            for (int i = 1; i < arr.size() - 1; ++i) {
                int t = arr.get(i) + arr.get(i + 1);
                if (s > t) {
                    s = t;
                    k = i;
                }
            }
            arr.set(k, s);
            arr.remove(k + 1);
            ++ans;
        }
        return ans;
    }

    private boolean isNonDecreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); ++i) {
            if (arr.get(i) < arr.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3507 _tcSol = new Solution3507();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,2,3,1]");
        try {
            int[] nums = new int[]{5, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPairRemoval(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPairRemoval(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
