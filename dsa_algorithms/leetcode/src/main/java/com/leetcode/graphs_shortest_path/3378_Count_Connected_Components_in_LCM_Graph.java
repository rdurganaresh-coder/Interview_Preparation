package com.leetcode.graphs_shortest_path;

class DSU3378 {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;

    public DSU3378(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    public void makeSet(int v) {
        parent.put(v, v);
        rank.put(v, 1);
    }

    public int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void unionSet(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            if (rank.get(u) < rank.get(v)) {
                int temp = u;
                u = v;
                v = temp;
            }
            parent.put(v, u);
            if (rank.get(u).equals(rank.get(v))) {
                rank.put(u, rank.get(u) + 1);
            }
        }
    }
}

class Solution3378 {
    public int countComponents(int[] nums, int threshold) {
        DSU3378 dsu = new DSU3378(threshold);

        for (int num : nums) {
            for (int j = num; j <= threshold; j += num) {
                dsu.unionSet(num, j);
            }
        }

        Set<Integer> uniqueParents = new HashSet<>();
        for (int num : nums) {
            if (num > threshold) {
                uniqueParents.add(num);
            } else {
                uniqueParents.add(dsu.find(num));
            }
        }

        return uniqueParents.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3378 _tcSol = new Solution3378();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,8,3,9], threshold = 5");
        try {
            int[] nums = new int[]{2, 4, 8, 3, 9};
            int threshold = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countComponents(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,8,3,9,12], threshold = 10");
        try {
            int[] nums = new int[]{2, 4, 8, 3, 9, 12};
            int threshold = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countComponents(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
