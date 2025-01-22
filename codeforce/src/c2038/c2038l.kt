import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val options = getOptions()
//    options.forEach { println(it.joinToString(separator = ","))}
    var n1 = n
    var n2 = n
    var n3 = n

    var ans = 0
    while (n1 > 0 || n2 > 0 || n3 > 0) {
        val plank = options.filter { it[1] <= n1 && it[2] <= n2 && it[3] <= n3 }.maxBy { it[0] }
        var cnt = n
        if (plank[1] > 0)
            cnt = n1 / plank[1]
        if (plank[2] > 0)
            cnt = min(cnt, n2 / plank[2])
        if (plank[3] > 0)
            cnt = min(cnt, n3 / plank[3])
        ans += cnt
        n1 -= cnt * plank[1]
        n2 -= cnt * plank[2]
        n3 -= cnt * plank[3]
    }
    println(ans)
}

fun getOptions(): List<IntArray> {
    val ans = mutableListOf<IntArray>()
    for (i in 0..3)
        for (j in 0..3)
            for (k in 0..3) {
                val v = i * 18 + j * 21 + k * 25
                if (v <= 60) {
                    ans.add(intArrayOf(v, i, j, k))
                }
            }
    return ans
}