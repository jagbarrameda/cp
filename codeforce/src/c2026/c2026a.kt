import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (x, y, k) = readln().split(' ').map { it.toInt() }
        var l1 = IntArray(4)
        var l2 = IntArray(4)
        if (x >= k && y >= k) {
            l1[3] = y
            l2[2] = x
        } else {
            // l1: 0,0 -> x,y
            // l2: 0,y -> something (m2 = -y/x)
            l1[2] = min(k, min(x,y))
            l1[3] = l1[2]
            l2[0] = 0
            l2[1] = l1[2]
            l2[2] = l2[1]
            l2[3] = 0
        }

        println(l1.joinToString(" "))
        println(l2.joinToString(" "))
    }
}