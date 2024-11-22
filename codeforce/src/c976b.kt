import kotlin.math.sqrt

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val k = readln().toLong()
        var low = 0L
        var high = 2e18.toLong()
        while (low + 1 < high) {
            val n = low + (high - low) / 2
            var nOff = mysqrt(n)
            if (n - nOff >= k) {
                high = n
            } else {
                low = n
            }
        }
        println(high)
    }
}

fun mysqrt(n: Long): Long {
    var res = maxOf(1, sqrt(n.toDouble()).toLong() - 1)
    while ((res + 1) * (res + 1) <= n) res++
    return res
}