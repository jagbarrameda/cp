import kotlin.math.abs
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        val mins = IntArray(2 * n - 1) { 0 }
        for (i in 0 until n) {
            for (j in 0 until n) {
                val diff = j - i
                val idx = if (diff >= 0 && diff <= n - 1) diff else n - 1 - diff
                mins[idx] = min(mins[idx], a[i][j])
            }
        }
        println(abs(mins.sum()))
    }
}