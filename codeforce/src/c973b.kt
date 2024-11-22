fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toInt() }
        var ans : Long = 0L + a[n-1] - a[n-2]
        for (i in a.size - 3 downTo  0) {
            ans += a[i]
        }
        println(ans)
    }
}