import java.io.PrintWriter
import kotlin.math.min

fun main() {
    val has7 = fun(n: Long): Boolean {
        var nn = n
        while (nn > 0) {
            if (nn % 10 == 7L) return true
            nn /= 10
        }
        return false
    }
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        var ans = if (has7(n.toLong())) 0 else 10

        if (ans != 0) {
            var s = 9L
            for (i in 1..10) {
                var cnt = 1
                var nn = n + s
                while (cnt < ans) {
                    if (has7(nn)) {
                        break
                    }
                    nn += s
                    cnt++
                }
                ans = min(ans, cnt)
                s = 10 * s + 9
            }
        }
        C2067c.io.cout.println(ans)
    }
    C2067c.io.flush()
}

private object C2067c {
    object io {
        val cin = System.`in`.bufferedReader()
        val cout = PrintWriter(System.out.bufferedWriter(), false)
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