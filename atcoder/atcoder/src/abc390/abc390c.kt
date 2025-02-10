import kotlin.math.max
import kotlin.math.min

fun main() {
    val (h,w) = readln().split(" ").map { it.toInt() }
    val m = mutableListOf<String>()
    var rect = IntArray(4) { -1 } // top, left, bottom, right
    var j = 0
    for (i in 0 until h) {
        val a = readln()
        m.add(a)
        val f = a.indexOfFirst { it == '#' }
        if (f==-1) continue
        var l = a.indexOfLast { it == '#' }
        if (rect[0] == -1) rect[0] = i
        rect[2] = i
        if (rect[1] == -1 || rect[1] > f)
            rect[1] = f
        rect[3] = max(rect[3], l)
    }
    var ans = true
    if (rect[0]!=-1) {
        for (i in rect[0]..rect[2]) {
            ans = !(m[i].substring(rect[1], rect[3] + 1).contains('.'))
            if (!ans) break
        }
    }
    println(if (ans) "Yes" else "No")
}