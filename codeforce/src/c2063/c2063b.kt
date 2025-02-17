import java.util.Collections.sort
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, l, r) = readln().split(" ").map { it.toInt() }
        l--
        r--
        val a = readln().split(" ").map { it.toLong() }
        val a1 = a.filterIndexed { i, _ -> i < l }
        val a2 = a.filterIndexed { i, _ -> i in l..r }
        val a3 = a.filterIndexed { i, _ -> i > r }
        sort(a1)
        sort(a2)
        sort(a3)
        var ans = min(fff(a2, a1), fff(a2, a3))
        println(ans)
    }
}


fun fff(a: List<Long>, b: List<Long>): Long {
    if (b.isNotEmpty()) {
        var i = 0
        while (i < a.size && i < b.size) {
            if (b[i] < a[a.size - 1 - i]) i++
            else break
        }
        var ans = b.filterIndexed { idx, _ -> idx < i }.sum()
        ans += a.filterIndexed { idx, _ -> idx < a.size - i }.sum()
        return ans
    } else {
        return a.sum()
    }
}
