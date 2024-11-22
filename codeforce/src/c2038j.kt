import kotlin.math.max

fun main() {
    var n = readln().toInt()
    var cnt = 0
    while (n-- > 0) {
        val (e, c) = readln().split(" ")
        val i = c.toInt()
        if (e == "B") {
            println (if (cnt < i) "YES" else "NO")
            cnt = max(cnt - i, 0)
        }
        if (e == "P") cnt += i
    }
}
