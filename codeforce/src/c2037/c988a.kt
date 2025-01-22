fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        val cnt = IntArray(21)
        for (i in a) {
            cnt[i]++
        }
        var ans = 0
        for (i in cnt) {
            ans += i / 2
        }
        println(ans)
    }
}
