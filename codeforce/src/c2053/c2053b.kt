import java.io.PrintWriter
import kotlin.math.max
import kotlin.math.min

fun main() {
    var t = c2053b.nextInt()
    while (t-- > 0) {
        val n = c2053b.nextInt()
        var min = 400001
        var max = 1
        val a = mutableListOf<List<Int>>()
        for (i in 0 until n) {
            val l = c2053b.nextInts()
            min = min(min, l[0])
            max = max(max, l[1])
            a.add(l)
        }
        val cnt = IntArray(max - min + 1)
        for (l in a)
            if (l[0] == l[1])
                cnt[l[0] - min]++

        val pref = IntArray(cnt.size + 1)
        for (i in 1 until pref.size) {
            pref[i] = pref[i - 1] + if (cnt[i - 1] > 0) 1 else 0
        }
        for (l in a) {
            if (l[0] == l[1]) {
                c2053b.write(if (cnt[l[0] - min] == 1) "1" else "0")
            } else {
                val c = pref[l[1] - min + 1] - pref[l[0] - min]
                c2053b.write(if (c < l[1] - l[0] + 1) "1" else "0")
            }
        }
        c2053b.writeLine("")
    }
    c2053b.done()
}

object c2053b {
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