package com.leetcode.arrays_hashing_greedy;

class Solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int idx = m;
        List<Integer>[] groupItems = new List[n + m];
        int[] itemDegree = new int[n];
        int[] groupDegree = new int[n + m];
        List<Integer>[] itemGraph = new List[n];
        List<Integer>[] groupGraph = new List[n + m];
        Arrays.setAll(groupItems, k -> new ArrayList<>());
        Arrays.setAll(itemGraph, k -> new ArrayList<>());
        Arrays.setAll(groupGraph, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = idx++;
            }
            groupItems[group[i]].add(i);
        }
        for (int i = 0; i < n; ++i) {
            for (int j : beforeItems.get(i)) {
                if (group[i] == group[j]) {
                    ++itemDegree[i];
                    itemGraph[j].add(i);
                } else {
                    ++groupDegree[group[i]];
                    groupGraph[group[j]].add(group[i]);
                }
            }
        }
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            items.add(i);
        }
        var groupOrder = topoSort(groupDegree, groupGraph, items);
        if (groupOrder.isEmpty()) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        for (int gi : groupOrder) {
            items = groupItems[gi];
            var itemOrder = topoSort(itemDegree, itemGraph, items);
            if (itemOrder.size() != items.size()) {
                return new int[0];
            }
            ans.addAll(itemOrder);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> topoSort(int[] degree, List<Integer>[] graph, List<Integer> items) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i : items) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int i = q.poll();
            ans.add(i);
            for (int j : graph[i]) {
                if (--degree[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return ans.size() == items.size() ? ans : List.of();
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
        Solution1203 _tcSol = new Solution1203();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]");
        try {
            int n = 8;
            int m = 2;
            int[] group = new int[]{-1, -1, 1, 0, 0, 1, 0, -1};
            List<List<Integer>> beforeItems = _tcL(_tcL(), _tcL(6), _tcL(5), _tcL(6), _tcL(3, 6), _tcL(), _tcL(), _tcL());
            System.out.println("  Output  : " + _tcShow(_tcSol.sortItems(n, m, group, beforeItems)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,3,4,1,5,2,0,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]");
        try {
            int n = 8;
            int m = 2;
            int[] group = new int[]{-1, -1, 1, 0, 0, 1, 0, -1};
            List<List<Integer>> beforeItems = _tcL(_tcL(), _tcL(6), _tcL(5), _tcL(6), _tcL(3), _tcL(), _tcL(4), _tcL());
            System.out.println("  Output  : " + _tcShow(_tcSol.sortItems(n, m, group, beforeItems)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}