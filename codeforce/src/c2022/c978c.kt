fun main() {
    var t = readln().toInt()
    while (t-->0) {
        val n = readln().toInt()
        val s1 = readln()
        val s2 = readln()
        var ans : Int = C978c.solve(s1, s2, 0, 0, Array<IntArray>(2) { IntArray(s2.length) })
        println(ans)
    }
}

object C978c {
    fun solve(s1: String, s2: String, i: Int, j: Int, dp: Array<IntArray>): Int {
        if (i >= s1.length) return 0
        if (j >= s2.length) return 0
        if (dp[i][j] != 0) return dp[i][j]
        var ans = 0

        dp[i][j] = ans
        return ans
    }
}

