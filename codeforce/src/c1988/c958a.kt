import kotlin.math.ceil

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        println("${1 + ceil(1.0 * (n - k) / (k - 1)).toInt()}")
    }
}