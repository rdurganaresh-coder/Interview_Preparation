package com.leetcode.arrays_hashing_greedy;

class Solution0599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < list2.length; ++i) {
            d.put(list2[i], i);
        }
        List<String> ans = new ArrayList<>();
        int mi = 1 << 30;
        for (int i = 0; i < list1.length; ++i) {
            if (d.containsKey(list1[i])) {
                int j = d.get(list1[i]);
                if (i + j < mi) {
                    mi = i + j;
                    ans.clear();
                    ans.add(list1[i]);
                } else if (i + j == mi) {
                    ans.add(list1[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0599 _tcSol = new Solution0599();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "list1 = [\"Shogun\",\"Tapioca Express\",\"Burger King\",\"KFC\"], list2 = [\"Piatti\",\"The Grill at Torrey Pines\",\"Hungry Hunter Steakhouse\",\"Shogun\"]");
        try {
            String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
            String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRestaurant(list1, list2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Shogun\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "list1 = [\"Shogun\",\"Tapioca Express\",\"Burger King\",\"KFC\"], list2 = [\"KFC\",\"Shogun\",\"Burger King\"]");
        try {
            String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
            String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRestaurant(list1, list2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Shogun\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "list1 = [\"happy\",\"sad\",\"good\"], list2 = [\"sad\",\"happy\",\"good\"]");
        try {
            String[] list1 = new String[]{"happy", "sad", "good"};
            String[] list2 = new String[]{"sad", "happy", "good"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRestaurant(list1, list2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"sad\",\"happy\"]");
        System.out.println();
    }
}
