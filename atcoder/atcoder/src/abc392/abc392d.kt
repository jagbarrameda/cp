import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val m = Array(n) { readln().split(" ").map { it.toInt() } }
    val p = Array(n) { mutableMapOf<Int,Int>() }
    for (i in 0 until n) {
        val a = m[i]
        val cnt = mutableMapOf<Int,Int>()
        for (j in 1 until a.size) {
            cnt.merge(a[j], 1, Int::plus)
        }
        p[i] = cnt
    }

    var ans = 0.0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            var sameCnt = 0L
            for ((f1,c1) in p[i]) {
                if (p[j].containsKey(f1)) {
                    sameCnt += 1L * c1 * p[j][f1]!!
                }
            }
            val totalCnt = 1L * m[i][0] * m[j][0]
            val prob = 1.0 * sameCnt / totalCnt
            ans = max(ans, prob)
        }
    }
    println(ans)
}