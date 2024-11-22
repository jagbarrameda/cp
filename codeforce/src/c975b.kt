fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, q) = readln().split(' ').map { it.toInt() }
        val x = readln().split(" ").map { it.toLong() }
        val k = readln().split(" ").map { it.toLong() }
        val m = mutableMapOf<Long, Long>()
        m[0L + n - 1] = 1L
        for (i in 1 until n) {
            var cnt = 1L * i * (1L * n - i)
            val noIntegers = 0L + x[i] - x[i-1] - 1L
            m[cnt] = m.getOrDefault(cnt, 0L) + noIntegers
            cnt = 0L + i + (i + 1L) * (n - 1L - i)
            m[cnt] = m.getOrDefault(cnt, 0L) + 1L
        }
        println(k.map { m[it] ?: 0 }.joinToString(" "))
    }
}