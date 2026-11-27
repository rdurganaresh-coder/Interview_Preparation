# 535. Encode and Decode TinyURL

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/encode-and-decode-tinyurl/

---

[中文文档](/solution/0500-0599/0535.Encode%20and%20Decode%20TinyURL/README.md)

## Description

<blockquote>Note: This is a companion problem to the <a href="https://leetcode.com/discuss/interview-question/system-design/" target="_blank">System Design</a> problem: <a href="https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/" target="_blank">Design TinyURL</a>.</blockquote>

<p>TinyURL is a URL shortening service where you enter a URL such as <code>https://leetcode.com/problems/design-tinyurl</code> and it returns a short URL such as <code>http://tinyurl.com/4e9iAk</code>. Design a class to encode a URL and decode a tiny URL.</p>

<p>There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.</p>

<p>Implement the <code>Solution</code> class:</p>

<ul>
	<li><code>Solution()</code> Initializes the object of the system.</li>
	<li><code>String encode(String longUrl)</code> Returns a tiny URL for the given <code>longUrl</code>.</li>
	<li><code>String decode(String shortUrl)</code> Returns the original long URL for the given <code>shortUrl</code>. It is guaranteed that the given <code>shortUrl</code> was encoded by the same object.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> url = &quot;https://leetcode.com/problems/design-tinyurl&quot;
<strong>Output:</strong> &quot;https://leetcode.com/problems/design-tinyurl&quot;

<strong>Explanation:</strong>
Solution obj = new Solution();
string tiny = obj.encode(url); // returns the encoded tiny url.
string ans = obj.decode(tiny); // returns the original url after decoding it.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= url.length &lt;= 10<sup>4</sup></code></li>
	<li><code>url</code> is guranteed to be a valid URL.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> We need a reversible short URL. Hashing to a fixed string can collide and needs a conflict table.
>
> The short code need not be unpredictable, so a monotonic id suffices. A map stores `id -> long URL`; the short form is the domain plus that id, and decode reads the last path segment. Both operations are constant time.

#### Java

```java
public class Codec {
    private Map<String, String> m = new HashMap<>();
    private int idx = 0;
    private String domain = "https://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String v = String.valueOf(++idx);
        m.put(v, longUrl);
        return domain + v;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int i = shortUrl.lastIndexOf('/') + 1;
        return m.get(shortUrl.substring(i));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
```
