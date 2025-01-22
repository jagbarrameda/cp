import kotlin.math.max
import kotlin.math.min

fun main() {
    var (n, k, q) = readln().split(" ").map { it.toInt() }
    val aa = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 1 until aa.size) {
        for (r in aa[i].indices) {
            aa[i][r] = aa[i][r] or aa[i - 1][r]
        }
    }
    val a = Array(k) { IntArray(n) }
    for (i in a.indices) {
        for (j in a[i].indices) {
            a[i][j] = aa[j][i]
        }
    }

    while (q-- > 0) {
        var m = readln().toInt()
        var low = 0
        var high = n - 1
        while (m-- > 0) {
            val b = readln().split(" ")
            if (low > high)
                continue
            if (b[1] == "<") {
                high = min(high, upperBound(a[b[0].toInt() - 1], b[2].toInt()))
            } else {
                low = max(low, lowerBound(a[b[0].toInt() - 1], b[2].toInt()))
            }
        }

        println(if (low > high) -1 else low + 1)
    }
}

fun lowerBound(a: IntArray, target: Int): Int {
    var l = 0
    var r = a.size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (a[mid] <= target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return l
}

fun upperBound(a: IntArray, target: Int): Int {
    var l = 0
    var r = a.size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (a[mid] < target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return if (l == a.size || a[l] < target) l else l - 1
}