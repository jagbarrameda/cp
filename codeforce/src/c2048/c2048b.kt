fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, k) = readln().split(" ").map { it.toInt() }
        val ans = IntArray(n)
        var max = n
        var min = 1
        var i = 0
        while (i < k - 1) {
            ans[i++] = max--
        }
        while (i < n) {
            ans[i++] = min++
            var rep = 1
            while (i < n && rep++ < k) {
                ans[i++] = max--
            }
        }
        println(ans.joinToString(" "))
    }
}
