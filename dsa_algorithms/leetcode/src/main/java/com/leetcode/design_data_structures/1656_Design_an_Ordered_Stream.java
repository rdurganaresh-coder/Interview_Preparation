package com.leetcode.design_data_structures;

class OrderedStream1656 {
    private int ptr = 1;
    private String[] data;

    public OrderedStream1656(int n) {
        data = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        data[idKey] = value;
        List<String> ans = new ArrayList<>();
        while (ptr < data.length && data[ptr] != null) {
            ans.add(data[ptr++]);
        }
        return ans;
    }
}

/**
 * Your OrderedStream1656 object will be instantiated and called as such:
 * OrderedStream1656 obj = new OrderedStream1656(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
