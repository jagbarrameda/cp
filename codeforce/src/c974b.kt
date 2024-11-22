import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, k) = readln().split(" ").map { it.toInt() }
        k = min(k, n)
        val pairs = k / 2
        if (k % 2 == 0) {
            println(if (pairs % 2 == 0) "YES" else "NO")
            continue
        }
        println(if (pairs % 2 == n % 2) "YES" else "NO")
    }
}
/*
5
1 1
2 1
2 2
3 2
4 4
 */