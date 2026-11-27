package com.leetcode.bit_manipulation_math;

class Solution2094 {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int x : digits) {
            ++cnt[x];
        }
        List<Integer> ans = new ArrayList<>();
        for (int x = 100; x < 1000; x += 2) {
            int[] cnt1 = new int[10];
            for (int y = x; y > 0; y /= 10) {
                ++cnt1[y % 10];
            }
            boolean ok = true;
            for (int i = 0; i < 10 && ok; ++i) {
                ok = cnt[i] >= cnt1[i];
            }
            if (ok) {
                ans.add(x);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2094 _tcSol = new Solution2094();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "digits = [2,1,3,0]");
        try {
            int[] digits = new int[]{2, 1, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findEvenNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[102,120,130,132,210,230,302,310,312,320]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "digits = [2,2,8,8,2]");
        try {
            int[] digits = new int[]{2, 2, 8, 8, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findEvenNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[222,228,282,288,822,828,882]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "digits = [3,7,5]");
        try {
            int[] digits = new int[]{3, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findEvenNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}