package com.leetcode.arrays_hashing_greedy;

class Solution1648 {
    private static final int MOD = (int) 1e9 + 7;

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            int t = inventory[i];
            inventory[i] = inventory[j];
            inventory[j] = t;
        }
        long ans = 0;
        int i = 0;
        while (orders > 0) {
            while (i < n && inventory[i] >= inventory[0]) {
                ++i;
            }
            int nxt = i < n ? inventory[i] : 0;
            int cnt = i;
            long x = inventory[0] - nxt;
            long tot = cnt * x;
            if (tot > orders) {
                int decr = orders / cnt;
                long a1 = inventory[0] - decr + 1, an = inventory[0];
                ans += (a1 + an) * decr / 2 * cnt;
                ans += (a1 - 1) * (orders % cnt);
            } else {
                long a1 = nxt + 1, an = inventory[0];
                ans += (a1 + an) * x / 2 * cnt;
                inventory[0] = nxt;
            }
            if (tot >= orders) {
                orders = 0;
            } else {
                orders -= (int) tot;
            }
            ans %= MOD;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1648 _tcSol = new Solution1648();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "inventory = [2,5], orders = 4");
        try {
            int[] inventory = new int[]{2, 5};
            int orders = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(inventory, orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "inventory = [3,5], orders = 6");
        try {
            int[] inventory = new int[]{3, 5};
            int orders = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(inventory, orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();
    }
}