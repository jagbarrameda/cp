import kotlin.math.abs

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var ans = true
        for (i in 1 until a.size) {
            val d = abs(a[i] - a[i - 1])
            if (d != 5 && d != 7) {
                ans = false
                break
            }
        }
        println(if (ans) "YES" else "NO")
    }
}