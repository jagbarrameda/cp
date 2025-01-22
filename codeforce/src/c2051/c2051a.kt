fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        val b = readln().split(" ").map { it.toInt() }
        var ans = 0
        for (i in 0 until n - 1) {
            if (a[i] > b[i+1]) ans += a[i] - b[i+1]
        }
        ans += a[n-1]
        println(ans)
    }
}
