import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m, v) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toLong() }.toLongArray()
        val pref = LongArray(n)
        val suff = LongArray(n)
        pref[0] = a[0]
        suff[n-1] = a[n-1]
        for (i in 1 until n) {
            pref[i] = a[i]+pref[i-1]
            suff[n-1-i] = a[n-1-i] + suff[n-1-i+1]
        }
        val posL = IntArray(m+1)
        posL[0] = -1
        var taste = 0L
        var servedCreatures = 0
        for (i in 0 until n) {
            if (servedCreatures == m) {
                break
            }
            taste += a[i]
            if (taste >= v) {
                servedCreatures++
                posL[servedCreatures] = i
                taste = 0
            }
        }
        if (servedCreatures != m) {
            println(-1)
            continue
        }
        val posR = IntArray(m+1)
        servedCreatures = 0
        taste = 0
        posR[0] = n
        for (i in n - 1 downTo 0) {
            taste += a[i]
            if (taste >= v) {
                servedCreatures++
                posR[servedCreatures] = i
                taste = 0
            }
            if (servedCreatures == m) {
                break
            }
        }
        if (servedCreatures != m) {
            println(-1)
            continue
        }

        val totalTaste = a.sum()

        var ans = -1L
        for (leftSize in 0 until m+1) {
            val rightSize = m - leftSize
            var leftTaste = 0L
            var rightTaste = 0L
            if (leftSize > 0) {
                leftTaste = pref[posL[leftSize]];
            }
            if (rightSize > 0) {
                rightTaste = suff[posR[rightSize]];
            }
            ans = max(ans, totalTaste - leftTaste - rightTaste)
        }

//        println(pref.joinToString(" "))
//        println(suff.joinToString(" "))
        println(ans)
    }
}