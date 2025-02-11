import java.io.PrintWriter
import kotlin.math.abs
import kotlin.math.max

fun main() {
    var t = C2065e.io.nextInt()
    while (t-- > 0) {
        val (n, m, k) = C2065e.io.nextInts()
        if (k > max(n, m) || abs(n - m) > k) C2065e.io.write("-1\n")
        else {
            if (n > m) C2065e.io.writeLine("0".repeat(k) + "10".repeat(n - k) + "1".repeat(m - n + k))
            else C2065e.io.writeLine("0".repeat(n - m + k) + "10".repeat(m - k) + "1".repeat(k))
        }
    }
    C2065e.io.done()
}

private object C2065e {
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