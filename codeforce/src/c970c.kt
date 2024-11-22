import kotlin.math.sqrt

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (l, r) = readln().split(" ").map { it.toInt() }
        r -= l
        l = 0
        var ans = sqrt(2.0 * r).toInt()
        while (ans * ans + ans <= 2 * r) {
            ans++
        }
        println(ans)
    }
}