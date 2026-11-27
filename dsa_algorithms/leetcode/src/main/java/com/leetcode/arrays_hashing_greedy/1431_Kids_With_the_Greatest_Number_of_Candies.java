package com.leetcode.arrays_hashing_greedy;

class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int mx = 0;
        for (int candy : candies) {
            mx = Math.max(mx, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= mx);
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1431 _tcSol = new Solution1431();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candies = [2,3,5,1,3], extraCandies = 3");
        try {
            int[] candies = new int[]{2, 3, 5, 1, 3};
            int extraCandies = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kidsWithCandies(candies, extraCandies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true,true,false,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candies = [4,2,1,1,2], extraCandies = 1");
        try {
            int[] candies = new int[]{4, 2, 1, 1, 2};
            int extraCandies = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kidsWithCandies(candies, extraCandies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,false,false,false]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "candies = [12,1,12], extraCandies = 10");
        try {
            int[] candies = new int[]{12, 1, 12};
            int extraCandies = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.kidsWithCandies(candies, extraCandies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,true]");
        System.out.println();
    }
}