fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (p1, p2, p3) = readln().split(' ').map { it.toInt() }
        val s = p1 + p2 + p3
        val ans = if (p1 + p2 <= p3) {
            p1 + p2
        } else {
            s / 2
        }
        println(if (s % 2 != 0) -1 else ans)
    }
}