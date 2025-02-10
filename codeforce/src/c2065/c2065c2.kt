import java.io.PrintWriter
import java.util.*
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        C2065c2.io.nextLine() // n, m
        val a = C2065c2.io.nextLongArray()
        val b = TreeSet(C2065c2.io.nextLongs())
        a[0] = min(a[0], b.min() - a[0])
        var ans = true
        for (i in 1 until a.size) {
            // get best j
            val target = a[i - 1] + a[i]
            val bj = b.ceiling(target)
            if (bj != null) {
                if (a[i] < a[i - 1])
                    a[i] = bj - a[i]
                else
                    a[i] = min(a[i], bj - a[i])
            }
            if (a[i] < a[i - 1]) {
                ans = false
                break
            }
        }
        C2065c2.io.write(if (ans) "YES\n" else "NO\n")
    }
    C2065c2.io.flush()
}

object C2065c2 {
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
        fun nextLongArray(): LongArray {
            val splits = nextLine().split(space)
            val ans = LongArray(splits.size)
            var i = 0
            for (s in splits) {
                ans[i++] = s.toLong()
            }
            return ans
        }
        fun write(a: Int) = cout.write(a.toString() + space)
        fun write(s: String) = cout.write(s)
        fun writeLine(s: String) = cout.write("$s$endl")
        fun flush() = cout.flush()
        fun done() = cout.flush()
    }
}