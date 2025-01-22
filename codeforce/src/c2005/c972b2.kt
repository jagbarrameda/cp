import java.util.Arrays.sort
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, m, q) = readln().split(' ').map { it.toInt() }
        var b = readln().split(" ").map { it.toInt() }.toIntArray()
        var a = readln().split(" ").map { it.toInt() }
        sort(b)
        for (p in a) {
            if (p < b[0]) {
                println(b[0] - 1)
                continue
            }
            if (p > b[m - 1]) {
                println(n - b[m - 1])
                continue
            }
            val idx = getLowIdx(p, b)
            val mid = b[idx] + (b[idx + 1] - b[idx]) / 2
            println(
                max(
                    abs(mid - p),
                    min(
                        mid - b[idx],
                        b[idx + 1] - mid
                    )
                )
            )
        }
    }
}

private fun getLowIdx(t: Int, b: IntArray): Int {
    if (t < b[0]) {
        return -1
    }
    if (t > b[b.size - 1]) {
        return b.size - 1
    }
    var l = 0
    var r = b.size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (b[mid] <= t) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return l - 1
}