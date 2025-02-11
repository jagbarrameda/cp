fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        var ans = false
        for (i in 0..2000) {
            if (y == x + 1 - 9 * i) {
                ans = true
                break
            }
        }
        println(if (ans) "Yes" else "No")
    }
}
