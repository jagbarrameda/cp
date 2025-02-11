import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val cnt = IntArray(n + 1)
        readln().split(" ").forEach { cnt[it.toInt()]++ }
        var ans = true
        for (i in 1 until cnt.size - 1) {
            if (cnt[i] == 1) {
                ans = false
                break
            }
            cnt[i + 1] += max(0, cnt[i] - 2)
        }
        println(if (ans) "Yes" else "No")
    }
}
