package c2040

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (nl, k) = readln().split(' ').map { it.toLong() }
        val n = nl.toInt()
        k--
        if (n <= 60 && k >= (1 shl (n - 1))) {
            println(-1)
        } else {
            val ans = IntArray(n)
            var l = 0
            var r = n - 1
            for (i in 1 until n) {
                if (n - 1 - i > 60 || k < (1L shl (n - 1 - i))) {
                    ans[l] = i
                    l++
                } else {
                    ans[r] = i
                    r--
                    k -= (1L shl (n - 1 - i))
                }
            }
            ans[l] = n
            println(ans.joinToString(" "))
        }
    }
}