import kotlin.math.max
import kotlin.math.min


fun main() {
//    main1()
    C985c.main2()
}


object C985c {
    fun main2() {
        var t = readln().toInt()
        while (t-- > 0) {
            val n = readln().toInt()
            val a = readln().split(" ").map { it.toInt() }.toIntArray()
            var x1 = 0 // all include but last
            var x2 = -1 // best of all included skipping
            var x3 = -1 // best of best all included and adding current one
            for (i in a.indices) {
                x3 = max(x2, x3)
                x2 = max(x1, x2)
                if (a[i] > x1)
                    x1++
                else if (a[i] < x1)
                    x1--
                if (a[i] < x3)
                    x3--
                else if (a[i] > x3)
                    x3++
            }
            println(max(x2, x3))
        }
    }

    fun main1() {
        var t = readln().toInt()
        while (t-- > 0) {
            val n = readln().toInt()
            val a = readln().split(" ").map { it.toInt() }.toIntArray()
            var x = 0
            var ans = 0
            var l = 0
            var r = n - 1
            val mTend = C985c.min(a)
            while (l < n - 1) {
                if (a[l] > x) x++
                if (a[l] < x) x--
                ans = max(ans, x)

                r = n - 1
                while (r > l + 1) {
                    val cntEnd = n - 1 - r + 1
                    if (mTend[r] <= x) break
                    ans = max(ans, x + cntEnd)
                    if (x + cntEnd >= mTend[r]) {
                        break
                    }
                    r--
                }
                l++
            }
            println(ans)
        }
    }
    fun min(a: IntArray): IntArray {
        val ans = IntArray(a.size)
        ans[a.size - 1] = a[a.size - 1]
        for (i in a.size - 2 downTo 0) {
            ans[i] = min(a[i], ans[i + 1])
        }
        return ans
    }
}
