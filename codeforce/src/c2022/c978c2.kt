import java.util.Collections.sort
import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-->0) {
        val l = readln().split(" ")
        val n = l[0].toInt()
        val x = l[1].toInt()
        var a = readln().split(" ").map { it.toInt() }.toMutableList()
        var total = a.sum()
        var ans = 0
        while (total >0) {
            sort(a)
            a.reverse()
            println(a)
            val m = a.max()
            val ave = 1.0 * total / m
            var removed = 0
            for (i in a.indices) {
                val carleft = max(ave.toInt(), a[i] - m)
                removed += a[i] - carleft
                a[i] = carleft
                if (removed >= m * x) break
            }
            if (removed == 0) break
            total -= removed
            a = a.filter { it > 0 }.toMutableList()
            println(a)
            ans += m
        }
        println(ans)
    }
}