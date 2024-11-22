import kotlin.math.max
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val s = StringBuilder(readln())
        val q = readln().toInt()
        val b = mutableSetOf<Int>()
        for (i in s.indices) {
            if (s.substring(i, min(i + 4, s.length)) == "1100")
                b.add(i)
        }

        var j = 0
        while (j < q) {
            val (ii, qi) = readln().split(" ").map { it.toInt() }
            val ch = '0' + qi
            val i = ii - 1
            if (s[i] != ch) {
                s[i] = ch
                for (k in i - 3 .. i) {
                    if (s.substring(max(k, 0), min(k + 4, s.length)) == "1100") {
                        b.add(k)
                    } else {
                        b.remove(k)
                    }
                }
            }

            println(if (b.size > 0) "YES" else "NO")
            j++
        }

    }
}