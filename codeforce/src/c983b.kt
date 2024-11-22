import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        if (n == 1 || k == (n + 1) / 2) {
            println(1)
            println(1)
            continue
        }
        if (k == 1 || k == n) {
            println(-1)
            continue
        }

        if (k % 2 == 0) {
            // val m = 3
            println(3)
            println("1 $k ${k + 1}")
        } else {
            // val m = 5
            println(5)
            println("1 2 $k ${k + 1} ${k + 2}")
        }
    }
}