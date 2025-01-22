package stud


class SparseTable(nums: IntArray, private val f: (x: Int, y: Int) -> Int) {
    // f must be idempotent, e.g. min, max, gcd
    private val t: Array<IntArray>

    init {
        val n = nums.size
        // length for index i is the log of the distance to the end
        t = Array(n) { IntArray(1 + kotlin.math.log(n.toDouble() - it, 2.0).toInt()) }

        var i = 0
        var len = 1 // len = 2^i
        while (len < n) {
            var a = 0
            while (a + len - 1 < n) {
                // compute q(a,b), where b= a+len-1= a+2^i-1, 2^i>1
                if (len == 1) t[a][0] = nums[a] else t[a][i] = f(t[a][i - 1], t[a + len / 2][i - 1])
                a++
            }
            i++
            len *= 2
        }
    }

    fun q(a: Int, b: Int): Int {
        val i = kotlin.math.log(b - a + 1.0, 2.0).toInt()
        val len = Math.pow(2.0, i.toDouble()).toInt() // 2^i
        return f(t[a][i], t[b - len + 1][i])
    }
}