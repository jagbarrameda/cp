import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val bb = readln().split(" ").map { it.toInt() }
        val max = bb.max()
        val min = bb.min()
        val len = max - min + 1
        val cnt = IntArray(len)
        for (i in bb) cnt[i - min]++
        var score = 0
        for (i in min..max) {
            val cmpl = k - i
            if (cmpl < i) break
            if (cmpl == i) {
                score += cnt[i - min] / 2
            } else {
                val cmplIdx = cmpl - min
                if (cmplIdx >= 0 && cmplIdx < len) {
                    score += min(cnt[i - min], cnt[cmpl - min])
                }
            }
        }
        println(score)
    }
}
