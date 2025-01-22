import java.util.*
import kotlin.math.min

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val a = readln().split(' ').map { it.toInt() }
    val b = readln().split(' ').map { it.toInt() }
    val maxs = getMax(a, b)
    val suff = getSuf(maxs)

    var i = 0
    val ans = LongArray(n)
    var solved = true
    var rem = 0L + k
    while (i < n && rem > 0) {
        val myMax = maxs[i]
        val maxCapacityLeft = suff[i]
        if (rem - myMax > maxCapacityLeft) {
            solved = false
            break
        }
        val myC = rem - min(rem, maxCapacityLeft)
        ans[i] = myC
        rem -= myC
        i++
    }
    if (!solved) {
        Arrays.fill(ans, 0)
    }
    println(ans.joinToString (" "))
}

fun getMax(a: List<Int>, b: List<Int>): IntArray {
    val ans = IntArray(a.size)
    for (i in a.indices) {
        ans[i] = a[i] / b[i]
    }
    return ans
}

fun getSuf(arr: IntArray): LongArray {
    val ans = LongArray(arr.size)
    ans[arr.size - 1] = 0L
    for (i in arr.size - 2 downTo 0) {
        ans[i] = ans[i + 1].toLong() + arr[i + 1].toLong()
    }
    return ans
}
