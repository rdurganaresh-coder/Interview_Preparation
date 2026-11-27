package com.leetcode.design_data_structures;

class Spreadsheet3484 {
    private Map<String, Integer> d = new HashMap<>();

    public Spreadsheet3484(int rows) {
    }

    public void setCell(String cell, int value) {
        d.put(cell, value);
    }

    public void resetCell(String cell) {
        d.remove(cell);
    }

    public int getValue(String formula) {
        int ans = 0;
        for (String cell : formula.substring(1).split("\\+")) {
            ans += Character.isDigit(cell.charAt(0)) ? Integer.parseInt(cell)
                                                     : d.getOrDefault(cell, 0);
        }
        return ans;
    }
}

/**
 * Your Spreadsheet3484 object will be instantiated and called as such:
 * Spreadsheet3484 obj = new Spreadsheet3484(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
