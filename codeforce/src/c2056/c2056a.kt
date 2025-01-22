import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var ops = n
        var ans = 4*m
        readln().split(" ").map { it.toInt() }
        ops--
        while (ops-->0) {
            val (dx, dy) = readln().split(" ").map { it.toInt() }
            ans += 2 * min(m, dx)
            ans += 2 * min(m, dy)
        }
        println(ans)
    }
}
