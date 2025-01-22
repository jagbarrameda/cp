import kotlin.math.min

fun main() {
    var t = readln().toInt()
    val MAX = 3003
    while (t-- > 0) {
        val a = readln()
        val b = readln()
        val c = readln()

        // dp[i][j] - solution to problem using i chars from a and j chars from b, and i+j in c
        val dp = Array(a.length + 1) { IntArray(b.length + 1) { MAX } }
        dp[0][0] = 0
        for (ai in 1..a.length) {
            dp[ai][0] = dp[ai - 1][0] + if (c[ai - 1] != a[ai - 1]) 1 else 0
        }
        for (bi in 1..b.length) {
            dp[0][bi] = dp[0][bi - 1] + if (c[bi - 1] != b[bi - 1]) 1 else 0
        }

        for (ai in 1..a.length) {
            for (bi in 1..b.length) {
                dp[ai][bi] = min(
                    dp[ai][bi],
                    min(
                        dp[ai - 1][bi] + if (c[ai + bi - 1] != a[ai - 1]) 1 else 0,
                        dp[ai][bi - 1] + if (c[ai + bi - 1] != b[bi - 1]) 1 else 0
                    )
                )
            }
        }

        println(dp[a.length][b.length])
    }
}
