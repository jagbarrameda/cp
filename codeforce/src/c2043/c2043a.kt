import kotlin.math.floor
import kotlin.math.log

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var x = readln().toLong()
        var ans = 1
        while (x > 3) { x/=4; ans*=2; }
        println(ans)
        // some problem with log due to floating point arithmetic
//        val i = floor(log(0.0 + x, 4.0)).toInt()
//        println(1 shl i)
    }
}
