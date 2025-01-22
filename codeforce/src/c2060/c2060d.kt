import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toMutableList()
        var ans = true
        for (i in 0 until a.size - 1) {
            val min = min(a[i], a[i + 1])
            a[i] -= min
            a[i + 1] -= min
            ans = a[i] <= a[i + 1]
            if (!ans) break
        }
        println(if (ans) "YES" else "NO")
    }
}
