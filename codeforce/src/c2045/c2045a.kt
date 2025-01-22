import kotlin.math.max
import kotlin.math.min

fun main() {
    val s = readln()
    val cnt = IntArray(6)
    val vL = listOf('A', 'E', 'I', 'O', 'U')
    for (c: Char in s.toCharArray()) {
        when (c) {
            in vL -> cnt[0]++
            'Y' -> cnt[1]++
            'N' -> cnt[2]++
            'G' -> cnt[3]++
            else -> cnt[4]++ // cnt of cns other than Y, N, G
        }
    }
    var ans = 0
    var vow = cnt[0] + cnt[1]
    var cst = cnt[4] + cnt[2] + cnt[3]

    var sylCnt = min(vow, cst / 2) // n of size-3 syl
    vow -= sylCnt
    cst -= sylCnt * 2
    ans += sylCnt * 3

    var done = false
    if (cst == 0 && vow == 0) {
        done = true
    } else if (vow == 0 && cst > 0) {
        // all the Ys were not enough, let's consume as many NGs as possible
        val ngs = min(cnt[2], cnt[3])
        // we have cst ngs left
        ans += min(ngs, cst)
    } else if (cst == 0 && vow > 0) {
        // cst were not enough, and we have some Ys, or all Ys left and maybe some other vowels
        var normalVow = max(0, vow - cnt[1])
        var cst = cnt[1]
        sylCnt = min(normalVow, cst / 2)

    } else if (cst > 0 && vow > 0) {
        // possible??
    }

    println(ans)
}
