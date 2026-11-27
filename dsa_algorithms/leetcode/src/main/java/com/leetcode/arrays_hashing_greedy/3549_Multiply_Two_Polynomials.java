package com.leetcode.arrays_hashing_greedy;

class Solution3549 {
    public long[] multiply(int[] poly1, int[] poly2) {
        if (poly1 == null || poly2 == null || poly1.length == 0 || poly2.length == 0) {
            return new long[0];
        }

        int m = poly1.length + poly2.length - 1;
        int n = 1;
        while (n < m) n <<= 1;

        Complex[] fa = new Complex[n];
        Complex[] fb = new Complex[n];
        for (int i = 0; i < n; i++) {
            fa[i] = new Complex(i < poly1.length ? poly1[i] : 0, 0);
            fb[i] = new Complex(i < poly2.length ? poly2[i] : 0, 0);
        }

        fft(fa, false);
        fft(fb, false);

        for (int i = 0; i < n; i++) {
            fa[i] = fa[i].mul(fb[i]);
        }

        fft(fa, true);

        long[] res = new long[m];
        for (int i = 0; i < m; i++) {
            res[i] = Math.round(fa[i].re);
        }
        return res;
    }

    private static void fft(Complex[] a, boolean invert) {
        int n = a.length;

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >>> 1;
            while ((j & bit) != 0) {
                j ^= bit;
                bit >>>= 1;
            }
            j ^= bit;
            if (i < j) {
                Complex tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            Complex wlen = new Complex(Math.cos(ang), Math.sin(ang));

            for (int i = 0; i < n; i += len) {
                Complex w = new Complex(1, 0);
                int half = len >>> 1;
                for (int j = 0; j < half; j++) {
                    Complex u = a[i + j];
                    Complex v = a[i + j + half].mul(w);
                    a[i + j] = u.add(v);
                    a[i + j + half] = u.sub(v);
                    w = w.mul(wlen);
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                a[i].re /= n;
                a[i].im /= n;
            }
        }
    }

    private static final class Complex {
        double re, im;
        Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }
        Complex add(Complex o) {
            return new Complex(re + o.re, im + o.im);
        }
        Complex sub(Complex o) {
            return new Complex(re - o.re, im - o.im);
        }
        Complex mul(Complex o) {
            return new Complex(re * o.re - im * o.im, re * o.im + im * o.re);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3549 _tcSol = new Solution3549();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "poly1 = [3,2,5], poly2 = [1,4]");
        try {
            int[] poly1 = new int[]{3, 2, 5};
            int[] poly2 = new int[]{1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(poly1, poly2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,14,13,20]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "poly1 = [1,0,-2], poly2 = [-1]");
        try {
            int[] poly1 = new int[]{1, 0, -2};
            int[] poly2 = new int[]{-1};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(poly1, poly2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,0,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "poly1 = [1,5,-3], poly2 = [-4,2,0]");
        try {
            int[] poly1 = new int[]{1, 5, -3};
            int[] poly2 = new int[]{-4, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(poly1, poly2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-4,-18,22,-6,0]");
        System.out.println();
    }
}
