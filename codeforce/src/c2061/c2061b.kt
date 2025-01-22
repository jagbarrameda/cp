import java.util.Collections.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        sort(a)
        var sideI = -1
        for (i in n - 1 downTo 1) {
            if (a[i] == a[i - 1]) {
                sideI = i
                break
            }
        }
        var b1i = -1
        var b2i = -1
        if (sideI >= 0) {
            for (i in 0 until n) {
                if (i == sideI - 1 || i == sideI) continue
                b1i = i
                b2i = i + 1
                while (b2i == sideI || b2i == sideI - 1) b2i++
                if (b2i >= n) {
                    b1i = -1
                    b2i = -1
                    break
                }
                if (a[b2i] < a[b1i] + 2 * a[sideI]) break
                else {
                    b1i = -1
                    b2i = -1
                }
            }
        }

        if (sideI < 0 || b1i < 0 || b2i < 0) println("-1")
        else println("${a[sideI]} ${a[sideI - 1]} ${a[b1i]} ${a[b2i]}")
    }
}
