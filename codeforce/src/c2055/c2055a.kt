import kotlin.math.abs

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, a, b) = readln().split(" ").map { it.toInt() }
        println(if (abs(a - b) % 2 == 1) "NO" else "YES")
    }
}
