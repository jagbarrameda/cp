import java.io.PrintWriter

fun main() {
    var t = c2051f.nextInt()
    while (t-- > 0) {
        val (n, m, q) = c2051f.nextInts()
        val qs = c2051f.nextInts()
        val ans = mutableListOf<Int>()
        val seg = IntArray(2) { m }
        var low = 0
        var upp = n + 1
        for (a in qs) {
            val modseg = seg[0] != 0
            val modlow =
                if (low > 0) a > low
                else ((seg[0] != 0 && a in seg[0]..seg[1]) || a >= upp)
            val modupp =
                if (upp < n+1) a < upp
                else ((seg[0] != 0 && a in seg[0]..seg[1]) || a <= low)

            if (modseg) {
                if (a < seg[0] && seg[0] - 1 > low) {
                    seg[0]--
                } else if (a > seg[1] && seg[1] + 1 < upp) {
                    seg[1]++
                } else {
                    if (seg[0] == seg[1]) {
                        seg[0] = 0
                        seg[1] = n + 1
                    }
                }
            }

            if (modlow) {
                if ((seg[0] == 0 || low + 1 < seg[0]) && (low + 1 < upp)) low++
            }
            if (modupp) {
                if ((seg[0] == 0 || upp - 1 > seg[1]) && (upp - 1 > low)) upp--
            }

            var v = low
            v += (if (seg[0] > 0) seg[1] - seg[0] + 1 else 0)
            v += n - upp + 1

            ans.add(v)
        }
        c2051f.writeLine(ans.joinToString(" "))
    }
    c2051f.done()
}

object c2051f {
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

