import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, k) = readln().split(' ').map { it.toInt() }
        val a = readln().split(' ').map { it.toInt() }.sortedDescending().toIntArray()

        var score = 0
        for (i in 0 until n - 1 step 2) {
            val ch = min(a[i] - a[i+1], k)
            k -= ch
            score += a[i] - a[i + 1] - ch
        }
        if (n % 2 == 1)
            score += a[n - 1]

        println(score)
    }
}
