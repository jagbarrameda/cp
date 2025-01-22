import kotlin.math.max
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(' ').map { it.toLong() }
        if (n == 1) {
            println("1")
            continue
        }
        if (n == 2) {
            println(a[1] - a[0])
            continue
        }

        if (n % 2 == 0) {
            var ans = 0L
            var i = 1
            while (i < n) {
                val v = a[i] - a[i - 1]
                ans = max(ans, v)
                i += 2
            }
            println(ans)
            continue
        }

        val maxToEnd = LongArray(n)
        val maxToStart = LongArray(n)
        var i = 2
        while (i < n) {
            val v = a[i - 1] - a[i - 2]
            maxToStart[i] = max(v, maxToStart[i - 2])
            i += 2
        }
        i = n - 3
        while (i >= 0) {
            val v = a[i + 2] - a[i + 1]
            maxToEnd[i] = max(v, maxToEnd[i + 2])
            i -= 2
        }
        var ans = min(maxToStart[n - 1], maxToEnd[0])
        i = 2
        while (i <= n - 3) {
            ans = min(ans, max(maxToStart[i], maxToEnd[i]))
            i += 2
        }
        println(ans)
    }
}