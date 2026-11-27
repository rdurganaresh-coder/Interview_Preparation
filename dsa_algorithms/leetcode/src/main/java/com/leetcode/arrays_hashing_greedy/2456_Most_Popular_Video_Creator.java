package com.leetcode.arrays_hashing_greedy;

class Solution2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = ids.length;
        Map<String, Long> cnt = new HashMap<>(n);
        Map<String, Integer> d = new HashMap<>(n);
        for (int k = 0; k < n; ++k) {
            String c = creators[k], i = ids[k];
            long v = views[k];
            cnt.merge(c, v, Long::sum);
            if (!d.containsKey(c) || views[d.get(c)] < v
                || (views[d.get(c)] == v && ids[d.get(c)].compareTo(i) > 0)) {
                d.put(c, k);
            }
        }
        long mx = 0;
        for (long x : cnt.values()) {
            mx = Math.max(mx, x);
        }
        List<List<String>> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            if (e.getValue() == mx) {
                String c = e.getKey();
                ans.add(List.of(c, ids[d.get(c)]));
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2456 _tcSol = new Solution2456();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "creators = [\"alice\",\"bob\",\"alice\",\"chris\"], ids = [\"one\",\"two\",\"three\",\"four\"], views = [5,10,5,4]");
        try {
            String[] creators = new String[]{"alice", "bob", "alice", "chris"};
            String[] ids = new String[]{"one", "two", "three", "four"};
            int[] views = new int[]{5, 10, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostPopularCreator(creators, ids, views)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"alice\",\"one\"],[\"bob\",\"two\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "creators = [\"alice\",\"alice\",\"alice\"], ids = [\"a\",\"b\",\"c\"], views = [1,2,2]");
        try {
            String[] creators = new String[]{"alice", "alice", "alice"};
            String[] ids = new String[]{"a", "b", "c"};
            int[] views = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostPopularCreator(creators, ids, views)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"alice\",\"b\"]]");
        System.out.println();
    }
}