package com.leetcode.sql_database;

class Solution1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, List<String>> tables = new TreeMap<>();
        Set<String> items = new HashSet<>();
        for (List<String> o : orders) {
            int table = Integer.parseInt(o.get(1));
            String foodItem = o.get(2);
            tables.computeIfAbsent(table, k -> new ArrayList<>()).add(foodItem);
            items.add(foodItem);
        }
        List<String> sortedItems = new ArrayList<>(items);
        Collections.sort(sortedItems);
        List<List<String>> ans = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(sortedItems);
        ans.add(header);
        for (Map.Entry<Integer, List<String>> entry : tables.entrySet()) {
            Map<String, Integer> cnt = new HashMap<>();
            for (String item : entry.getValue()) {
                cnt.merge(item, 1, Integer::sum);
            }
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(entry.getKey()));
            for (String item : sortedItems) {
                row.add(String.valueOf(cnt.getOrDefault(item, 0)));
            }
            ans.add(row);
        }
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
        Solution1418 _tcSol = new Solution1418();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "orders = [[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]");
        try {
            List<List<String>> orders = _tcL(_tcL("David", "3", "Ceviche"), _tcL("Corina", "10", "Beef Burrito"), _tcL("David", "3", "Fried Chicken"), _tcL("Carla", "5", "Water"), _tcL("Carla", "5", "Ceviche"), _tcL("Rous", "3", "Ceviche"));
            System.out.println("  Output  : " + _tcShow(_tcSol.displayTable(orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"Table\",\"Beef Burrito\",\"Ceviche\",\"Fried Chicken\",\"Water\"],[\"3\",\"0\",\"2\",\"1\",\"0\"],[\"5\",\"0\",\"1\",\"0\",\"1\"],[\"10\",\"1\",\"0\",\"0\",\"0\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "orders = [[\"James\",\"12\",\"Fried Chicken\"],[\"Ratesh\",\"12\",\"Fried Chicken\"],[\"Amadeus\",\"12\",\"Fried Chicken\"],[\"Adam\",\"1\",\"Canadian Waffles\"],[\"Brianna\",\"1\",\"Canadian Waffles\"]]");
        try {
            List<List<String>> orders = _tcL(_tcL("James", "12", "Fried Chicken"), _tcL("Ratesh", "12", "Fried Chicken"), _tcL("Amadeus", "12", "Fried Chicken"), _tcL("Adam", "1", "Canadian Waffles"), _tcL("Brianna", "1", "Canadian Waffles"));
            System.out.println("  Output  : " + _tcShow(_tcSol.displayTable(orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"Table\",\"Canadian Waffles\",\"Fried Chicken\"],[\"1\",\"2\",\"0\"],[\"12\",\"0\",\"3\"]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "orders = [[\"Laura\",\"2\",\"Bean Burrito\"],[\"Jhon\",\"2\",\"Beef Burrito\"],[\"Melissa\",\"2\",\"Soda\"]]");
        try {
            List<List<String>> orders = _tcL(_tcL("Laura", "2", "Bean Burrito"), _tcL("Jhon", "2", "Beef Burrito"), _tcL("Melissa", "2", "Soda"));
            System.out.println("  Output  : " + _tcShow(_tcSol.displayTable(orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"Table\",\"Bean Burrito\",\"Beef Burrito\",\"Soda\"],[\"2\",\"1\",\"1\",\"1\"]]");
        System.out.println();
    }
}
