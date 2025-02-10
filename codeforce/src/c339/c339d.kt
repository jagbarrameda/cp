import java.io.PrintWriter
import C339d.IO;

fun main() {
    var (n, m) = IO.nextInts()
    val a = IO.nextLongs()
    val N = a.size shl 1
    val st = LongArray(N)
    val update: (Int, Long) -> Unit = { i, value ->
        val ch = (st.size shr 1) + i
        st[ch] = value
        var p = ch shr 1
        var d = 1
        while (p > 0) {
            val l = p shl 1
            val r = l + 1
            st[p] = if (d == 1) st[l] or st[r] else st[l] xor st[r]
            d = d xor 1
            p = p shr 1
        }
    }
    for (i in a.indices) {
        update(i, a[i])
    }
    while (m-- > 0) {
        val (p, b) = IO.nextLongs()
        update(p.toInt() - 1, b)
        IO.writeLine("${st[1]}")
    }
    IO.done()
}

object C339d {
    object IO {
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