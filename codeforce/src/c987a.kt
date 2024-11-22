fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var ans = 0
        var cnt = 0
        var i = 0
        while (i < a.size - 1) {
            if (a[i] == a[i + 1]) {
                cnt++
                if (cnt > ans) ans = cnt
            } else {
                cnt = 0
            }
            i++
        }
        println(a.size - 1 - ans)
    }
}
