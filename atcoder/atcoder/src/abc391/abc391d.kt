import java.io.PrintWriter
import java.util.Collections.sort

fun main() {
    val (n, w) = Abc391d.nextInts()
    val cols = Array<MutableList<Pair<Int, Int>>>(w) {
        mutableListOf()
    }
    val ba = Array(n) {
        var (v1, v2) = Abc391d.nextInts()
        v1--
        v2--
        val p = Pair(v1, v2)
        cols[v1].add(p)
        p
    }
    for (x in 0 until w) {
        sort(cols[x]) { a, b -> a.first.compareTo(b.first) }
    }
    val gone = IntArray(n) { Int.MAX_VALUE }
    var done = false
    while (cols.all { it.size == 0}) {
        var nextT = ba.maxOfOrNull { it.first } ?: Int.MAX_VALUE
        for (col in ba) {
//            gone[col]
        }
    }
    var q = Abc391d.nextInt()
    while (q-- > 0) {
        var (t, a) = Abc391d.nextInts()
        a--
        Abc391d.writeLine ( if (gone[a] > t)  "Yes" else "No")
    }
    Abc391d.done()
}


object Abc391d {
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