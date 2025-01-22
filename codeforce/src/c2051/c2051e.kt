import java.io.PrintWriter
import kotlin.math.max

fun main() {
    var t = c2051e.nextInt()
    while (t-- > 0) {
        val (n, k) = c2051e.nextInts()
        val l = mutableListOf<Pair<Long, Boolean>>()
        c2051e.nextLine().split(" ").forEach {  l.add(it.toLong() to true) }
        c2051e.nextLine().split(" ").forEach {  l.add(it.toLong() to false) }
        l.sortBy { it.first }
        var sells = n + 0L
        var ans = n + 0L
        var negRevs = 0L
        var i = 0
        while (i < l.size) {
            val v = l[i].first
            if (negRevs <= k)
                ans = max(ans, sells * v)
            while (i < l.size && l[i].first == v) {
                if (l[i].second) {
                    negRevs++
                } else {
                    negRevs--
                    sells--
                }
                i++
            }
        }

        c2051e.writeLine("$ans")
    }
    c2051e.done()
}

object c2051e {
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

