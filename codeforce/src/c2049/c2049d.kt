import java.io.PrintWriter
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m, k) = C2049D.io.nextInts()
        val g = List(n) { C2049D.io.nextLongs() }
        val dp = Array(n) { Array(m) { LongArray(m) { Long.MAX_VALUE } } }

        for (i in 0 until m) {
            dp[n - 1][m - 1][i] = g[n - 1][(m - 1 + i) % m] + k * i
            for (c in m - 2 downTo 0) {
                dp[n - 1][c][i] = g[n - 1][(c + i) % m] + dp[n - 1][c + 1][i]
            }
        }

        for (r in n - 2 downTo 0) {
            for (i in 0 until m) {
                for (j in 0 until m) {
                    // last column for row r shifted i, and row r+1 shifted j
                    dp[r][m - 1][i] = min(dp[r][m - 1][i], g[r][(m - 1 + i) % m] + dp[r + 1][m - 1][j] + i * k)
                }
                for (c in m - 2 downTo 0) {
                    // go right
                    dp[r][c][i] = min(dp[r][c][i], g[r][(c + i) % m] + dp[r][c + 1][i])
                    // go down
                    for (j in 0 until m) {
                        dp[r][c][i] = min(dp[r][c][i], g[r][(c + i) % m] + dp[r + 1][c][j] + i * k)
                    }
                }
            }
        }

        C2049D.io.writeLine("${dp[0][0].min()}")
    }
    C2049D.io.done()
}


object C2049D {

    object io {
        val cin = System.`in`.bufferedReader()
        val cout = PrintWriter(System.out.bufferedWriter())
        val endl = "\n"
        val space = " "
        fun nextLine() = cin.readLine()!!.trim()
        fun nextInt() = nextLine().toInt()
        fun nextLong() = nextLine().toLong()
        fun nextStrings() = nextLine().split(space)
        fun nextInts() = nextStrings().map { it.toInt() }
        fun nextLongs() = nextStrings().map { it.toLong() }
        fun write(a: Int) = cout.write(a.toString() + space)
        fun write(s: String) = cout.write(s)
        fun writeLine(s: String) = cout.write("$s$endl")
        fun flush() = cout.flush()
        fun done() = cout.flush()
    }
}
