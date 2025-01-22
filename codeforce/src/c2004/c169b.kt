import kotlin.math.max
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (l, r) = readln().split(' ').map { it.toInt() }
        var (L, R) = readln().split(' ').map { it.toInt() }
        var ans = when {
            (r < L || l > R) -> 1
            (l == L && r == R) -> r - l
            else ->
                (if (r == R) r else min(r, R) + 1) -
                        (if (l == L) l else max(l, L) - 1)
        }
        println(ans)
    }
}
