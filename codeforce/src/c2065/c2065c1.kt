import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toLong() }.toMutableList()
        val b = readln().toLong()
        a[0] = min(a[0], b - a[0])
        var ans = true
        for (i in 1 until a.size) {
            if (a[i] >= a[i-1]) {
                if (b - a[i] >= a[i - 1]) {
                    // can it be better?
                    a[i] = min(a[i], b - a[i])
                }
            } else {
                a[i]=b-a[i]
            }
            if (a[i] < a[i - 1]) {
                ans = false
                break
            }
        }
        println(if (ans) "Yes" else "No")
    }
}

/*
1
3 1
5 3 2
5

0 2 2
 */