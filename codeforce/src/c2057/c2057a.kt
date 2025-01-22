import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        println(max(n,m) + 1)
    }
}
