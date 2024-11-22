import java.util.*
import java.util.Arrays.sort
import kotlin.math.max

fun main() {
    var tt = readln().toInt()
    val d = intArrayOf(0, 1, -1)
    while (tt-- > 0) {
        val n = readln().toInt()
        val ans = IntArray(n)
        if (n < 5) {
            println(-1)
            continue
        }

        var i = 0
        ans[i++] = 1
        for (k in 7 .. n step 2) {
            ans[i++] = k
        }
        ans[i++] = 3
        ans[i++] = 5
        ans[i++] = 4
        ans[i++] = 2
        for (k in 6 .. n step 2) {
            ans[i++] = k
        }

        println(ans.joinToString(" "))
    }
}
