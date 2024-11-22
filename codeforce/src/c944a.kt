fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (a, b, c, d) = readln().split(" ").map { it.toInt() }
        if (a > b) {
            val x = a
            a = b
            b = x
        }
        if (c > d) {
            val x = c
            c = d
            d = x
        }
        val ans = (b < c || d < a) || ((a > c && b < d) || (c > a && d < b))
        println(if (!ans) "YES" else "NO")
    }
}