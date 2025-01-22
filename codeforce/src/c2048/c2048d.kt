import java.io.PrintWriter
import java.util.Collections.sort
import kotlin.math.min

fun main() {
    var t = io.nextInt()
    while (t-- > 0) {
        val (n, m) = io.nextInts()
        var a = io.nextInts()
        var kRating = a[0]
        a = a.filter { it > kRating }
        val b = io.nextInts()
        val b1 = b.filter { it <= kRating }// kevin can solve
        val b2 = b.filter { it > kRating }// kevin cannot solve
        val canSolveItCnt = canSolveIntCnt(a, b2) // how many can solve each problem that kevin cannot solve
        val ans = IntArray(m)

        for (k in 1..m) {
            // k == 1
            val c = m / k
            if (c < b1.size)
                ans[k - 1] = c
            else {
                // can be first place
                ans[k - 1] = b1.size / k

                // cannot be first place, choose the left tougher problems and put it in each left groups
                var left = c - ans[k - 1]
                var j = b2.size - k
                while (left > 0 && j >= 0) {
                    // can improve with preffix
                    ans[k - 1] += 1 + canSolveItCnt[j]
                    left--
                    j -= k
                }
            }
        }
        io.writeLine(ans.joinToString(" "))
    }
    io.done()
}

fun canSolveIntCnt(a: List<Int>, b: List<Int>): List<Int> {
    // can be made O(n lg m)
    val ans = MutableList(b.size) { 0 }
    for (i in b.indices) {
        ans[i] = a.count { it >= b[i] }
    }
    return ans
}

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

/*
4
4 4
4 3 7 5
2 5 4 6
5 5
5 0 4 8 6
1 3 9 2 7
6 7
1 1 4 5 1 4
1 9 1 9 8 1 0
7 6
1 9 1 9 8 1 0
1 1 4 5 1 4
*/

/* out
7 4 2 3
6 2 1 1 2
7 3 2 1 1 1 1
15 9 5 4 4 4
 */