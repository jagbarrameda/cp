fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m, k) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        val q = readln().split(" ").map { it.toInt() }.toHashSet()

        var ans = MutableList(m) { 0 }
        if (q.size == n) {
            ans = MutableList(m) { 1 }
        } else if (q.size == n - 1) {
            for (i in a.indices) {
                if (!q.contains(a[i])) ans[i] = 1
            }
        }
        println(ans.joinToString(""))
    }
}
