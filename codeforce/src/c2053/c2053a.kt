fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var ans = false
        for (i in 0 until n - 1) {
            val j = i + 1
            ans = (a[i] + a[i] > a[j] && a[i] + a[j] > a[i] && a[i] + a[j] > a[j] && a[j] + a[j] > a[i])
            if (ans) break
        }
        println(if (ans) "YES" else "NO")
    }
}
