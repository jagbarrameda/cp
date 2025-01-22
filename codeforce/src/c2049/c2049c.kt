fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, x, y) = readln().split(" ").map { it.toInt() }
        // normal ring
        val ans = IntArray(n)
        var i = x - 1
        var cnt = 0
        while (cnt < n) {
            ans[i] = 1
            i = (i + 2) % n
            cnt += 2
        }
        if (n % 2 == 1 || ans[x - 1] == ans[y - 1]) {
            // x is equal to x - 1 or to y, make x to 2
            ans[(x - 1 + 4 * n) % n] = 2
        }
        println(ans.joinToString(" "))
    }
}
