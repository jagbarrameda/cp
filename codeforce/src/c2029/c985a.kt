import kotlin.math.ceil

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (l, r, k) = readln().split(" ").map { it.toInt() }
        if (ceil((r - l + 1.0) / l).toInt() == 0)
            println(0)
        else
            println(C985A.f(l, r, k) - l + 1)
    }
}


object C985A {
    fun f(left: Int, right: Int, k: Int): Int {
        var l = left
        var r = right
        while (l <= r) {
            val mid = l + (r - l) / 2
            val n = ceil((right - mid + 1.0) / mid)
            if (n >= k) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return l - 1
    }
}