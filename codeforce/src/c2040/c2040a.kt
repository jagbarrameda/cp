package c2040

import kotlin.math.abs

fun main() {
    var t = readln().toInt()
    while (t-- >0) {
        val (n, k) = readln().split(' ').map { it.toInt() }
        val a = readln().split(' ').map { it.toInt() }
        var ans = -1
        for (i in a.indices) {
            var good = true
            for (j in a.indices) {
                if (i == j) continue
                if (abs(a[i]-a[j]) % k == 0) {
                    good = false
                    break
                }
            }
            if (good) {
                ans = i
                break
            }
        }
        if (ans == -1)
            println("NO")
        else {
            println("YES")
            println(ans + 1)
        }
    }
}