import java.util.Collections.sort
import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        sort(a)
//        println(a.joinToString(" "))
        var i = n - 1
        var ans = 1
        var len = 1
        i--
        while (0 <= i) {
            len++
            if (a[i] < a[i + 1] - 1) {
                len = 1
            } else {
                while (a[i] + k - 1 < a[i + len - 1]) {
                    len--
                }
            }
            ans = max(ans, len)
            i--
        }
        println(ans)
    }
}

/*
1
3 3
1 10 8

 */