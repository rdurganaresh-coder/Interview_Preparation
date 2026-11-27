package com.leetcode.arrays_hashing_greedy;

class Solution3447 {
    public int[] assignElements(int[] groups, int[] elements) {
        int mx = Arrays.stream(groups).max().getAsInt();
        int[] d = new int[mx + 1];
        Arrays.fill(d, -1);
        for (int j = 0; j < elements.length; ++j) {
            int x = elements[j];
            if (x > mx || d[x] != -1) {
                continue;
            }
            for (int y = x; y <= mx; y += x) {
                if (d[y] == -1) {
                    d[y] = j;
                }
            }
        }
        int n = groups.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = d[groups[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3447 _tcSol = new Solution3447();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "groups = [8,4,3,2,4], elements = [4,2]");
        try {
            int[] groups = new int[]{8, 4, 3, 2, 4};
            int[] elements = new int[]{4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignElements(groups, elements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,-1,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "groups = [2,3,5,7], elements = [5,3,3]");
        try {
            int[] groups = new int[]{2, 3, 5, 7};
            int[] elements = new int[]{5, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignElements(groups, elements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,1,0,-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "groups = [10,21,30,41], elements = [2,1]");
        try {
            int[] groups = new int[]{10, 21, 30, 41};
            int[] elements = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignElements(groups, elements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,0,1]");
        System.out.println();
    }
}
