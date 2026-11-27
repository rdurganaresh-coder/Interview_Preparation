# 3348. Smallest Divisible Digit Product II

**Difficulty:** Hard  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/smallest-divisible-digit-product-ii/

---

[中文文档](/solution/3300-3399/3348.Smallest%20Divisible%20Digit%20Product%20II/README.md)

## Description

<p>You are given a string <code>num</code> which represents a <strong>positive</strong> integer, and an integer <code>t</code>.</p>

<p>A number is called <strong>zero-free</strong> if <em>none</em> of its digits are 0.</p>

<p>Return a string representing the <strong>smallest</strong> <strong>zero-free</strong> number greater than or equal to <code>num</code> such that the <strong>product of its digits</strong> is divisible by <code>t</code>. If no such number exists, return <code>&quot;-1&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = &quot;1234&quot;, t = 256</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;1488&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>The smallest zero-free number that is greater than 1234 and has the product of its digits divisible by 256 is 1488, with the product of its digits equal to 256.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = &quot;12355&quot;, t = 50</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;12355&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>12355 is already zero-free and has the product of its digits divisible by 50, with the product of its digits equal to 150.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = &quot;11111&quot;, t = 26</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;-1&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>No number greater than 11111 has the product of its digits divisible by 26.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= num.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>num</code> consists only of digits in the range <code>[&#39;0&#39;, &#39;9&#39;]</code>.</li>
	<li><code>num</code> does not contain leading zeros.</li>
	<li><code>1 &lt;= t &lt;= 10<sup>14</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> We need the smallest zero-free integer that is at least $\textit{num}$ and whose digit product is divisible by $t$. With $|\textit{num}| \le 2 \times 10^5$ we cannot increment from $n$.
>
> If $t$ has a prime factor other than $2,3,5,7$, there is no answer. Otherwise we pack the remaining primes into digits $8,9,6,4$ so the length is minimized.
>
> From the right we try to raise one digit and fill the suffix with ones plus those packed digits; if the current length is too short we prepend ones. That yields the lexicographically smallest valid number.

#### Java

```java
class Solution {
    private static final int[][] DIGIT_PRIMES = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {2, 0, 0, 0},
        {0, 0, 1, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 1},
        {3, 0, 0, 0},
        {0, 2, 0, 0},
    };

    public String smallestNumber(String num, long t) {
        int[] required = new int[4];
        if (!factorize(t, required)) {
            return "-1";
        }
        int[] need = toDigits(required);
        if (sum(need) > num.length()) {
            return construct(need);
        }

        int[] prefix = new int[4];
        for (int i = 0; i < num.length(); ++i) {
            add(prefix, DIGIT_PRIMES[num.charAt(i) - '0']);
        }
        int firstZero = num.indexOf('0');
        if (firstZero == -1) {
            firstZero = num.length();
            if (isSubset(required, prefix)) {
                return num;
            }
        }

        int n = num.length();
        for (int i = n - 1; i >= 0; --i) {
            subtractInPlace(prefix, DIGIT_PRIMES[num.charAt(i) - '0']);
            int space = n - 1 - i;
            if (i > firstZero) {
                continue;
            }
            for (int bigger = num.charAt(i) - '0' + 1; bigger < 10; ++bigger) {
                int[] suffix = toDigits(subtract(subtract(required, prefix), DIGIT_PRIMES[bigger]));
                if (sum(suffix) <= space) {
                    StringBuilder ans = new StringBuilder();
                    ans.append(num, 0, i);
                    ans.append(bigger);
                    ans.append("1".repeat(space - sum(suffix)));
                    ans.append(construct(suffix));
                    return ans.toString();
                }
            }
        }
        int[] ext = toDigits(required);
        return "1".repeat(n + 1 - sum(ext)) + construct(ext);
    }

    private boolean factorize(long t, int[] counts) {
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; ++i) {
            while (t % primes[i] == 0) {
                t /= primes[i];
                ++counts[i];
            }
        }
        return t == 1;
    }

    private int[] toDigits(int[] primes) {
        int count8 = primes[0] / 3;
        int remaining2 = primes[0] % 3;
        int count9 = primes[1] / 2;
        int count3 = primes[1] % 2;
        int count4 = remaining2 / 2;
        int count2 = remaining2 % 2;
        int count6 = 0;
        if (count2 == 1 && count3 == 1) {
            count2 = 0;
            count3 = 0;
            count6 = 1;
        }
        if (count3 == 1 && count4 == 1) {
            count2 = 1;
            count6 = 1;
            count3 = 0;
            count4 = 0;
        }
        return new int[] {
            0, 0, count2, count3, count4, primes[2], count6, primes[3], count8, count9};
    }

    private String construct(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int d = 2; d < 10; ++d) {
            sb.append(String.valueOf(d).repeat(digits[d]));
        }
        return sb.toString();
    }

    private boolean isSubset(int[] a, int[] b) {
        for (int i = 0; i < a.length; ++i) {
            if (b[i] < a[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] subtract(int[] a, int[] b) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            res[i] = Math.max(0, a[i] - b[i]);
        }
        return res;
    }

    private void subtractInPlace(int[] a, int[] b) {
        for (int i = 0; i < a.length; ++i) {
            a[i] = Math.max(0, a[i] - b[i]);
        }
    }

    private void add(int[] a, int[] b) {
        for (int i = 0; i < a.length; ++i) {
            a[i] += b[i];
        }
    }

    private int sum(int[] a) {
        int s = 0;
        for (int v : a) {
            s += v;
        }
        return s;
    }
}
```
