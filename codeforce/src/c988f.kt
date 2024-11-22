import kotlin.math.max

//https://codeforces.com/contest/2037/problem/E

fun main() {
    var tt = readln().toInt()
    while (tt-- > 0) {
        val (n, m, k) = readln().split(" ").map { it.toInt() }
        val h = readln().split(" ").map { it.toLong() }
        val x = readln().split(" ").map { it.toLong() }
        var l = 1
        var r = h.max().toInt()
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (C988f.works(mid, m, k, h, x)) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        println(if (l <= 0 || l > h.max().toInt()) -1 else l)
    }
}

object C988f {
    internal fun works(i: Int, m: Int, k: Int, h: List<Long>, x: List<Long>): Boolean {
        val intervals = getIntervals(i, m, h, x)
        val starts = mutableListOf<Long>()
        val ends = mutableListOf<Long>()
        for (j in intervals.indices) {
            if (intervals[j][0] <= intervals[j][1]) {
                starts.add(intervals[j][0])
                ends.add(intervals[j][1])
            }
        }
        starts.sort()
        ends.sort()
        var nextS = 0
        var nextE = 0
        var cnt = 0
        while (nextS < starts.size) {
            if (starts[nextS] <= ends[nextE]) {
                cnt++
                nextS++
                if (cnt >= k) return true
            } else {
                nextE++
                cnt--
            }
        }
        return false
    }

    private fun getIntervals(hits: Int, maxDamage: Int, h: List<Long>, x: List<Long>): Array<LongArray> {
        val ans = Array(x.size) { LongArray(2) }
        for (j in x.indices) {
            val maxDist = max(-1, (maxDamage - ((h[j] + hits - 1L) / hits)))
            ans[j][0] = x[j] - maxDist // minimum p that kills enemy j with i stomps of damage m
            ans[j][1] = x[j] + maxDist // maximum p that kills enemy j with i stomps of damage m
        }
        return ans
    }
}