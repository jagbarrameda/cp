import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var (x ,y) = readln().split(" ").map { it.toInt() }
        var ans = n / min(x, y)
        if (ans * min(x, y) != n) ans++
        println(ans)
    }
}