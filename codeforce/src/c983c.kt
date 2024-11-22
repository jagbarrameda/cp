import java.util.Arrays.sort
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toLong() }.toLongArray()
        sort(a)
        var ans = n
        var i = 0
        var end = 1
        while (i < n - 1) {
            val target = a[i] + a[i + 1] - 1
            end = find(target, end, a)
//            println("$target, $end, [${a.joinToString (" ")}]")
            if (end >= n) {
                ans = min(ans, i)
                break
            } else {
                ans = min(ans, i + n - end)
            }
            i++
        }
        println(ans)
    }
}

fun find(target: Long, from: Int, a: LongArray): Int {
    val n = a.size
    if (a[n - 1] <= target) {
        return n
    }

    var l = from
    var r = n - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
//        println("mid $mid")
        if (a[mid] <= target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return l
}