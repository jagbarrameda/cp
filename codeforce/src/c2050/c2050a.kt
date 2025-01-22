fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var ans = 0
        var l = 0
        for (i in 0 until n) {
            l += readln().length
            if (l <= m) {
                ans++
            }
        }
        println(ans)
    }
}
