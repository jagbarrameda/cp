import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val s = readln()
        var ans = (1L * n) * (n + 1) / 2
        var cnt = 0
        for (i in n - 1 downTo 0) {
            if (s[i] == '1' && i > cnt) {
                ans -= (i+1)
                cnt++
            } else {
                cnt  = max(cnt - 1, 0)
            }
            println("$i $cnt")
        }
        println(ans)
    }
}