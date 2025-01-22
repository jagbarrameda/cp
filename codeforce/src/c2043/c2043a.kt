import kotlin.math.floor
import kotlin.math.log

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val x = readln().toLong()
        val i = floor(log(0.0 + x, 4.0)).toInt()
        println(1 shl i)
    }
}
