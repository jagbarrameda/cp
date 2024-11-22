import kotlin.math.max
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }

        val maxPref = IntArray(n)
        maxPref[0] = a[0]
        for (i in 1 until n) {
            maxPref[i] = max(a[i], maxPref[i - 1])
        }

        val minSuf = IntArray(n)
        minSuf[n - 1] = a[n - 1]
        for (i in n - 2 downTo 0) {
            minSuf[i] = min(a[i], minSuf[i + 1])
        }

        val ans = IntArray(n)
        ans[n - 1] = maxPref[n - 1]
        for (i in n - 2 downTo 0) {
            ans[i] = maxPref[i]
            if (maxPref[i] > minSuf[i + 1]) {
                ans[i] = ans[i + 1]
            }
        }

        println(ans.joinToString(" "))
    }
}

/*
4
5
1 2 3 4 5
5
1 3 2 5 4
1
1
5
2 1 4 5 3

1
10
10 9 2 1 4 9 4 9 4 5

1
10
9 7 10 10 10 1 10 6 6 6

 */