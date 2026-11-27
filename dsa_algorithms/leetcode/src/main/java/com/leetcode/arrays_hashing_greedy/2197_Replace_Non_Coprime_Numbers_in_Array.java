package com.leetcode.arrays_hashing_greedy;

class Solution2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stk = new ArrayList<>();
        for (int x : nums) {
            stk.add(x);
            while (stk.size() > 1) {
                x = stk.get(stk.size() - 1);
                int y = stk.get(stk.size() - 2);
                int g = gcd(x, y);
                if (g == 1) {
                    break;
                }
                stk.remove(stk.size() - 1);
                stk.set(stk.size() - 1, (int) ((long) x * y / g));
            }
        }
        return stk;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2197 _tcSol = new Solution2197();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [6,4,3,2,7,6,2]");
        try {
            int[] nums = new int[]{6, 4, 3, 2, 7, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceNonCoprimes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[12,7,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,1,1,3,3,3]");
        try {
            int[] nums = new int[]{2, 2, 1, 1, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceNonCoprimes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,1,3]");
        System.out.println();
    }
}