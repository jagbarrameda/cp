fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        val p = readln().split(" ").map { it.toInt() - 1 }
        val s = readln()
        val ans = IntArray(n) { -1 }
        for (i in 0 until n) {
            if (ans[i] != -1) continue
            var j = i
            var c = '1' - s[j]
            while (p[j] != i) {
                j = p[j]
                c += '1' - s[j]
            }
            j = i
            ans[j] = c
            while (p[j] != i) {
                j = p[j]
                ans[j] = c
            }
        }
        println(ans.joinToString(" "))
    }
}