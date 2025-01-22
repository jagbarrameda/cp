import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (x, m) = readln().split(" ").map { it.toLong() }
        var maxy = x shl 1
        maxy = min(m, maxy)
        var ans = 0L
        for (y in 1 .. maxy) {
//            if (x == y) continue
            val a = y xor x
            if (a == 0L) continue
            if (x % a == 0L || y % a == 0L)
                ans++
        }
        println(ans) // ignore x == y
    }
}
