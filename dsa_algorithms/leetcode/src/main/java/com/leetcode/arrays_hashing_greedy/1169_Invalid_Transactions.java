package com.leetcode.arrays_hashing_greedy;

class Solution1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Item1169>> d = new HashMap<>();
        Set<Integer> idx = new HashSet<>();
        for (int i = 0; i < transactions.length; ++i) {
            var e = transactions[i].split(",");
            String name = e[0];
            int time = Integer.parseInt(e[1]);
            int amount = Integer.parseInt(e[2]);
            String city = e[3];
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(new Item1169(time, city, i));
            if (amount > 1000) {
                idx.add(i);
            }
            for (Item1169 item : d.get(name)) {
                if (!city.equals(item.city) && Math.abs(time - item.t) <= 60) {
                    idx.add(i);
                    idx.add(item.i);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i : idx) {
            ans.add(transactions[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1169 _tcSol = new Solution1169();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "transactions = [\"alice,20,800,mtv\",\"alice,50,100,beijing\"]");
        try {
            String[] transactions = new String[]{"alice,20,800,mtv", "alice,50,100,beijing"};
            System.out.println("  Output  : " + _tcShow(_tcSol.invalidTransactions(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"alice,20,800,mtv\",\"alice,50,100,beijing\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "transactions = [\"alice,20,800,mtv\",\"alice,50,1200,mtv\"]");
        try {
            String[] transactions = new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"};
            System.out.println("  Output  : " + _tcShow(_tcSol.invalidTransactions(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"alice,50,1200,mtv\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "transactions = [\"alice,20,800,mtv\",\"bob,50,1200,mtv\"]");
        try {
            String[] transactions = new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"};
            System.out.println("  Output  : " + _tcShow(_tcSol.invalidTransactions(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"bob,50,1200,mtv\"]");
        System.out.println();
    }
}

class Item1169 {
    int t;
    String city;
    int i;

    Item1169(int t, String city, int i) {
        this.t = t;
        this.city = city;
        this.i = i;
    }
}