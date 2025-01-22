import kotlin.math.max
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val r1 = readln().split(" ").map { it.toLong() }
        val r2 = readln().split(" ").map { it.toLong() }
        var ans = max(r1[0], r2[0])
        var min = min(r1[0], r2[0])
        for (i in 1 until n) {
            ans += max(r1[i], r2[i])
            min = max(min, min(r1[i], r2[i]))
        }
        println(ans+min)
    }
}
