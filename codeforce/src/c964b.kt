import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (a1, a2, b1, b2) = readln().split(' ').map { it.toInt() }
        var w = 0
        if (a1 > a2) {
            w = a1
            a1 = a2
            a2 = w
        }
        if (b1 > b2) {
            w = b1
            b1 = b2
            b2 = w
        }

        var ans = 0
        var win = sign((sign(0.0 + a1 - b1) + sign(0.0 + a2 - b2))).toInt()
        if (win > 0) ans += 2
        win = sign((sign(0.0 + a1 - b2) + sign(0.0 + a2 - b1))).toInt()
        if (win > 0) ans += 2
        println(ans)
    }
}