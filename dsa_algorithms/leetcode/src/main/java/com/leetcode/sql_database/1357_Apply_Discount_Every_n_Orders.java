package com.leetcode.sql_database;

class Cashier1357 {
    private int i;
    private int n;
    private int discount;
    private Map<Integer, Integer> d;

    public Cashier1357(int n, int discount, int[] products, int[] prices) {
        this.i = 0;
        this.n = n;
        this.discount = discount;
        this.d = new HashMap<>();
        for (int j = 0; j < products.length; j++) {
            this.d.put(products[j], prices[j]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        this.i = (this.i + 1) % this.n;
        double x = 0;
        for (int j = 0; j < product.length; j++) {
            x += this.d.get(product[j]) * amount[j];
        }
        if (this.i == 0) {
            return x - (this.discount * x) / 100.0;
        }
        return x;
    }
}

/**
 * Your Cashier1357 object will be instantiated and called as such:
 * Cashier1357 obj = new Cashier1357(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */