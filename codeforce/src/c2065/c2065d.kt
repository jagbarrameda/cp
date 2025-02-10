import java.io.PrintWriter
import java.util.Arrays.sort

fun main() {
    var t = C2065d.io.nextInt()
    while (t-- > 0) {
        val (n, m) = C2065d.io.nextInts()
        val a = Array(n) { C2065d.io.nextInts().toMutableList() }
        for (i in a.indices) {
            a[i].add(a[i].sum())
        }
        sort(a) { x, y -> y[m].compareTo(x[m]) }
        var ans = 0L
        var mult = n * m
        for (i in a.indices) {
            for (j in 0 until m) {
                ans += a[i][j] * mult
                mult--
            }
        }
        C2065d.io.writeLine("" + ans)
    }
    C2065d.io.done()
}

object C2065d {

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