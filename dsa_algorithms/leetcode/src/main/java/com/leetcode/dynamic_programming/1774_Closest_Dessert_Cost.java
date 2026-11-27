package com.leetcode.dynamic_programming;

class Solution1774 {
    private List<Integer> arr = new ArrayList<>();
    private int[] ts;
    private int inf = 1 << 30;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ts = toppingCosts;
        dfs(0, 0);
        Collections.sort(arr);
        int d = inf, ans = inf;

        for (int x : baseCosts) {
            for (int y : arr) {
                int i = search(target - x - y);
                for (int j : new int[] {i, i - 1}) {
                    if (j >= 0 && j < arr.size()) {
                        int t = Math.abs(x + y + arr.get(j) - target);
                        if (d > t || (d == t && ans > x + y + arr.get(j))) {
                            d = t;
                            ans = x + y + arr.get(j);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private int search(int x) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr.get(mid) >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void dfs(int i, int t) {
        if (i >= ts.length) {
            arr.add(t);
            return;
        }
        dfs(i + 1, t);
        dfs(i + 1, t + ts[i]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1774 _tcSol = new Solution1774();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "baseCosts = [1,7], toppingCosts = [3,4], target = 10");
        try {
            int[] baseCosts = new int[]{1, 7};
            int[] toppingCosts = new int[]{3, 4};
            int target = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestCost(baseCosts, toppingCosts, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "baseCosts = [2,3], toppingCosts = [4,5,100], target = 18");
        try {
            int[] baseCosts = new int[]{2, 3};
            int[] toppingCosts = new int[]{4, 5, 100};
            int target = 18;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestCost(baseCosts, toppingCosts, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "baseCosts = [3,10], toppingCosts = [2,5], target = 9");
        try {
            int[] baseCosts = new int[]{3, 10};
            int[] toppingCosts = new int[]{2, 5};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestCost(baseCosts, toppingCosts, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}