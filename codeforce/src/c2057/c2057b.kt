import java.util.Collections.sort
import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        val repmap = mutableMapOf<Int,Int>()
        for (i in a) repmap[i] = 1 + (if (repmap[i]!=null) repmap[i]!! else 0)
        val rep = repmap.values.toMutableList()
        sort(rep)
        var ans = rep.size
        var kk = k
        var i = 0
        while (kk > 0 && i < rep.size) {
            if (rep[i] <= kk) {
                ans--
                kk -= rep[i]
                i++
            } else {
                break
            }
        }
        println(max(ans, 1))
    }
}
