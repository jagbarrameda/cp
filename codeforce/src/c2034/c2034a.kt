import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val max = a * b + 1
        var ans = 0
        for (m in min(a, b)..max) {
            if (m % a == m % b) {
                ans = m
                break
            }
        }
        println(ans)
    }
}
