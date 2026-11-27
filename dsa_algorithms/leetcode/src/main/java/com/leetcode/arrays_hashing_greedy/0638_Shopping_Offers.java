package com.leetcode.arrays_hashing_greedy;

class Solution0638 {
    private final int bits = 4;
    private int n;
    private List<Integer> price;
    private List<List<Integer>> special;
    private Map<Integer, Integer> f = new HashMap<>();

    public int shoppingOffers(
        List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = needs.size();
        this.price = price;
        this.special = special;
        int mask = 0;
        for (int i = 0; i < n; ++i) {
            mask |= needs.get(i) << (i * bits);
        }
        return dfs(mask);
    }

    private int dfs(int cur) {
        if (f.containsKey(cur)) {
            return f.get(cur);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += price.get(i) * (cur >> (i * bits) & 0xf);
        }
        for (List<Integer> offer : special) {
            int nxt = cur;
            boolean ok = true;
            for (int j = 0; j < n; ++j) {
                if ((cur >> (j * bits) & 0xf) < offer.get(j)) {
                    ok = false;
                    break;
                }
                nxt -= offer.get(j) << (j * bits);
            }
            if (ok) {
                ans = Math.min(ans, offer.get(n) + dfs(nxt));
            }
        }
        f.put(cur, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0638 _tcSol = new Solution0638();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]");
        try {
            List<Integer> price = _tcL(2, 5);
            List<List<Integer>> special = _tcL(_tcL(3, 0, 5), _tcL(1, 2, 10));
            List<Integer> needs = _tcL(3, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.shoppingOffers(price, special, needs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]");
        try {
            List<Integer> price = _tcL(2, 3, 4);
            List<List<Integer>> special = _tcL(_tcL(1, 1, 0, 4), _tcL(2, 2, 1, 9));
            List<Integer> needs = _tcL(1, 2, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.shoppingOffers(price, special, needs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}