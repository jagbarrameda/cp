import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, x) = readln().split(' ').map { it.toInt() }
    val f = Array(n) { readln().split(" ").map { it.toInt() } }
    var dp = Array(3) { MutableList(x + 1) { 0 } }

    for (i in 0..2) {
        dp[i][0] = 0
    }

    for (k in 0 until n) {
        val newdp = Array(3) { mutableListOf<Int>() }
        for (i in 0..2) {
            if (f[k][0] - 1 != i) {
                newdp[i] = dp[i]
            } else {
                newdp[i] = dp[i].toMutableList()
                val calCnt = f[k][2]
                val vitCnt = f[k][1]
                for (totalCal in calCnt..x) {
                    if (dp[i][totalCal - calCnt] == -1) continue
                    newdp[i][totalCal] = max(newdp[i][totalCal], dp[i][totalCal - calCnt] + vitCnt)
                }
            }
        }
        dp = newdp
    }

    var ans = 0
    var c1 = 0
    while (c1 <= x) {
        var c2 = 0
        while (c1 + c2 <= x) {
            val c3 = x - c1 - c2
            ans = max(ans, min(dp[0][c1], min(dp[1][c2], dp[2][c3])))
            c2++
        }
        c1++
    }

    println(ans)

}