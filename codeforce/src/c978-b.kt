import kotlin.math.max


fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, x) = readln().split(" ").map { it.toLong() }
        val a = readln().split(" ").map { it.toLong() }
        val ans = max(a.max(), (a.sum() + x - 1L) / x)
        println(ans)
    }
}