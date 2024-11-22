fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (a, b) = readln().split(" ").map { it.toInt() }
        b %= 2
        println(if (b <= 2 * a && (a - 2 * b) % 2 == 0) "YES" else "NO")
    }
}
