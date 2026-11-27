# 1185. Day of the Week

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/day-of-the-week/

---

[中文文档](/solution/1100-1199/1185.Day%20of%20the%20Week/README.md)

## Description

<p>Given a date, return the corresponding day of the week for that date.</p>

<p>The input is given as three integers representing the <code>day</code>, <code>month</code> and <code>year</code> respectively.</p>

<p>Return the answer as one of the following values&nbsp;<code>{&quot;Sunday&quot;, &quot;Monday&quot;, &quot;Tuesday&quot;, &quot;Wednesday&quot;, &quot;Thursday&quot;, &quot;Friday&quot;, &quot;Saturday&quot;}</code>.</p>

<p><strong>Note:</strong> January 1, 1971 was a Friday.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> day = 31, month = 8, year = 2019
<strong>Output:</strong> &quot;Saturday&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> day = 18, month = 7, year = 1999
<strong>Output:</strong> &quot;Sunday&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> day = 15, month = 8, year = 1993
<strong>Output:</strong> &quot;Sunday&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The given dates are valid dates between the years <code>1971</code> and <code>2100</code>.</li>
</ul>

## Solutions

### Solution 1: Library Functions

> **Thinking**
>
> Mapping a Gregorian date to a weekday is already in the standard library. Build the date and format its weekday name, without hand-rolled leap-year or month-length logic.

The simplest approach is to use the date library provided by the language to get the day of the week for the given year, month, and day.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
import java.util.Calendar;

class Solution {
    private static final String[] WEEK
        = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return WEEK[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
```

### Solution 2: Zeller's Congruence

> **Thinking**
>
> Method 1 needs a date library. Zeller's congruence computes the weekday from century, year-of-century, month, and day; January and February are months $13$ and $14$ of the previous year. No date type is required.

We can use Zeller's Congruence to calculate the day of the week. Zeller's Congruence is as follows:

$$
w = (\left \lfloor \frac{c}{4} \right \rfloor - 2c + y + \left \lfloor \frac{y}{4} \right \rfloor + \left \lfloor \frac{13(m+1)}{5} \right \rfloor + d - 1) \bmod 7
$$

Where:

- `w`: Day of the week (starting from Sunday)
- `c`: First two digits of the year
- `y`: Last two digits of the year
- `m`: Month (the range of m is from 3 to 14, that is, in Zeller's Congruence, January and February of a certain year are considered as the 13th and 14th month of the previous year. For example, January 1, 2003 is considered as the 1st day of the 13th month of 2002)
- `d`: Day
- `⌊⌋`: Floor function (round down)
- `mod`: Modulo operation

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public String dayOfTheWeek(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int c = y / 100;
        y %= 100;
        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday"}[(w + 7) % 7];
    }
}
```
