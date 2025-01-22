fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (x, m) = readln().split(" ").map { it.toLong() }
//        var maxy = x shl 1
//        maxy = m // max(m, maxy)
        var ans = 0L
        for (y in 1 .. m) {
            val a = y xor x
//            if (a == 0L) continue // x == y
            if (a % x == 0L || a % y == 0L)
                ans++
        }
        println(ans) // ignore x == y
    }
}
