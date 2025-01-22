fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, a, b, c) = readln().split(" ").map { it.toInt() }

        var ans = 0
        var d = 0
        if (n > a + b + c) {
            ans = n / (a + b + c)
            d = (a + b + c) * ans
            ans *= 3
        }
        if (d < n) {
            d += a
            ans++
        }
        if (d < n) {
            d += b
            ans++
        }
        if (d < n) {
            d += c
            ans++
        }
        println(ans)
    }
}
