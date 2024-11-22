import java.util.Collections.sort
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-->0) {
        val l = readln().split(" ")
        val n = l[0].toInt()
        val r = l[1].toInt()
        var a = readln().split(" ").map { it.toInt() }
        sort(a)
        var ans = 0
        var left = 0
        var freeRows = r
        for (i in n - 1 downTo 0) {
            left += a[i] % 2
            ans += a[i] / 2 * 2
            freeRows -= a[i] / 2
        }
//        println("ans: $ans")
//        println("left: $left")
//        println("free rows: $freeRows")
        ans += min(left, 2 * freeRows - left)
        println(ans)
//        println("--")
    }
}