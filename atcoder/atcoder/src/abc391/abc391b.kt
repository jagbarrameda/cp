fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s = Array(n) { readln() }
    val t = Array(m) { readln() }
    var a = 0
    var b = 0
    for (startI in 0 until n - m + 1) {
        var f = false
        for (j in 0 until n - m + 1) {
            if (s[startI].substring(j, j + m) != t[0]) continue
            a = startI
            b = j
            f = true
            for (i in 1 until m) {
                if (s[a + i].substring(b, b + m) != t[i]) {
                    f = false
                    break
                }
            }
            if (f) break
        }
        if (f) break
    }
    println("${a + 1} ${b + 1}")
}