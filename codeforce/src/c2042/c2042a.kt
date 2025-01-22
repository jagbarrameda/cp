import java.util.Collections.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        sort(a)
        var ans = 0
        var acc = 0
        for (i in a.size - 1 downTo 0) {
            if (a[i] + acc < k) {
                acc += a[i]
                continue
            }
            if (a[i] + acc == k) {
                acc += a[i]
                ans = 0
                break
            }
            if (a[i] + acc > k) {
                ans = k - acc
                acc = k
                break
            }
        }
        if (acc < k) ans = k - acc
        println(ans)
    }
}
