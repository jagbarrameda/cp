import java.io.PrintWriter

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = c2053c.nextLongs()
        if (k == 1L)
            c2053c.write("${n * (n + 1) / 2}\n")
        else {
            val v = c2053c.f(1, n, k)
            c2053c.write("${v.first}\n")
        }
    }
    c2053c.done()
}

object c2053c {
    fun f(l: Long, r: Long, k: Long): Pair<Long, Int> {
        if ((r - l + 1) < k) return 0L to 0
        if (l == r) return l to 1
        val mid = l + (r - l) / 2
        var sum = 0L
        var cnt = 0
        if ((r - l + 1) % 2 == 0L) {
            val a = f(l, mid, k)
            sum = a.first + (a.second * mid + a.first)
            cnt = 2 * a.second
        } else {
            val a = f(l, mid - 1, k)
            sum = mid + a.first + (a.second * mid + a.first)
            cnt = 2 * a.second + 1
        }
//        println("$l to $r, $k -> $sum with $cnt")
        return sum to cnt
    }

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