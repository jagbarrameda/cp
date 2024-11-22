fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toInt() }
        var ans = 0
        for (i in 0 until n step 2) {
            ans += a[i]
        }
        for (i in 1 until n step 2) {
            ans -= a[i]
        }
        println(ans)
    }
}