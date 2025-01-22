package stud


class FenwickTreeMin(
    n: Int
) {
    /* from https://cp-algorithms.com/data_structures/fenwick.html */
    /**
     * binary indexed tree
     */
    private val bit: MutableList<Int> = MutableList(n) { 0 }
    private val INF = Int.MAX_VALUE

    constructor(a: List<Int>) : this(a.size) {
        for (i in a.indices) update(i, a[i])
    }

    fun getMin(r: Int): Int {
        var r = r
        var ret = INF
        while (r >= 0) {
            ret = kotlin.math.min(ret, bit[r])
            r = (r and (r + 1)) - 1
        }
        return ret
    }

    fun update(idx: Int, value: Int) {
        var idx = idx
        while (idx < bit.size) {
            bit[idx] = kotlin.math.min(bit[idx], value)
            idx = idx or (idx + 1)
        }
    }
}