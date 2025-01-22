import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map(String::toInt)
        val s = readln()
        val pref = IntArray(n + 1)
        for (i in 1..n) {
            pref[i] = pref[i - 1] + (s[i - 1] - '0')
        }
        var ans = -1
        for (m in 1 until s.length) {
            if (maxDiff(pref.size - 1, pref, m) >= k) {
                ans = m
                break
            }
        }
        println(ans)
    }
}

fun maxDiff(end: Int, pref: IntArray, m: Int): Int {
    if (m < 0) return -1
    if (m == 0) return 0
    if (m == 1) return 0
    if (end < m) return -1
    var ans = 0
    for (i in m - 1 until end) {
        val t = maxDiff(i, pref, m - 1)
        if (t < 0) continue // not valid
        val cnt = end - i
        val cnt1s = pref[end] - pref[i]
        val s = (cnt1s) * (m - 1) - (cnt - cnt1s) * (m - 1)
        ans = max(ans, t + s)
    }
    return ans
}

/*
Given an array a of size n.
The score is defined as S = a[0] + i * Sum (a[i] - a[i-1]) for 0<i<n.
Compute the score.
 */
/*
Given an array a of size n.
The score is defined as S = a[0] + i * Sum (a[i] - a[i-1]) for 0<i<n.
Compute the score without using multiplications.
 */

/*
Given an array a of size n.
The score is defined as S = a[0] + i * Sum (a[i] - a[i-1]) for 0<i<n.
Compute the score without using multiplications in O(n)
 */


/*
Given an array a of size n.
Given an array b of size m < n.

The score of is defined as
Compute the score.
 */