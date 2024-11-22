fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, b, c) = readln().split(" ").map { it.toLong() }
        if (b == 0L) {
            if (c < n - 2) println(-1)
            else if (c == n - 1 || c == n - 2) println(n - 1)
            else println(n)
            continue
        }
        if (c >= n) {
            println(n)
            continue
        }
        var k = (n - 1L - c) / b + 1
        println(n - k)
    }
}
