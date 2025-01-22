import java.util.*

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toInt() }.toIntArray()
        var ans = 0
        var changed = true
        while (changed) {
            var b = IntArray(n)
            doyear(a, b)
            changed = Arrays.equals(a, b)
            a = b
        }
        println(ans)
    }
}

fun doyear(a: IntArray, b: IntArray) {
    Arrays.fill(b, 0)
    for (i in 0 until a.size) {
        if (a[i] > 0) b[i] = 1
    }
}