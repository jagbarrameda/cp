import kotlin.math.abs
import kotlin.math.max

fun main() {
    var t = readln().toInt()

    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }.toMutableList()

        var ans = a.sum()
        var end = n-1
        while (end >= 0) {
            val s = a.filterIndexed { idx, _ -> idx <= end }.sum()
            if (end != n-1) ans = max(ans, abs(s))
            for (j in 0 until end) a[j] = (a[j+1]-a[j])
            end--
        }

        println(ans)
    }
}
