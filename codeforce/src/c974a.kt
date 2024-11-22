import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        var c = 0
        var ans = 0
        for (i in a.indices) {
            if (a[i] >= k) {
                c += a[i]
                continue
            }
            if (a[i] == 0 && c > 0) {
                c--
                ans++
                continue
            }
        }
        println(ans)
    }
}