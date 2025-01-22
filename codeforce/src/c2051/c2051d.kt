import java.io.PrintWriter
import java.util.Collections.sort

fun main() {
    var t = readln().toInt()
    val ansL = mutableListOf<Long>()
    while (t-- > 0) {
        val (n, x, y) = c2051d.nextLongs()
        val a = c2051d.nextLongs()
        val sum = a.sum()
        val min = sum - y
        val max = sum - x
        sort(a)

        var start = 0
        while (start < n - 1 && a[start] + a[n.toInt() - 1] < min) start++
        if (start == n.toInt() - 1) {
            ansL.add(0)
            continue
        }
        var l = n.toInt() - 1
        var r = n.toInt() - 1

        var ans = 0L
        for (i in start until n.toInt() - 1) {
            if (l == i) l = i + 1
            while (l - 1 > i && a[i] + a[l - 1] >= min) l--
            while (l <= r && a[i] + a[r] > max) r--
            if (r < i + 1) break
            ans += r - l + 1L
        }
        ansL.add(ans)
    }
    c2051d.writeLine(ansL.joinToString(separator = "\n"))
    c2051d.done()
}


object c2051d {
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
1
7 10 13
4 2 5 2 4 3 1

 */