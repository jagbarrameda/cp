package stud


class FenwickTreeSum(
    n: Int
) {
    /* from https://cp-algorithms.com/data_structures/fenwick.html */
    /**
     * binary indexed tree
     */
    private val bit: MutableList<Int> = MutableList(n) { 0 }

    constructor(a: List<Int>) : this(a.size) {
        // O(NlogN)       a.forEachIndexed { i, e -> add(i, e) }
        // O(N)
        for (i in a.indices) {
            bit[i] += a[i]
            val r = i or (i + 1)
            if (r < a.size) bit[r] += bit[i]
        }
    }

    /**
     * Update the tree with a new value at index i.
     */
    fun sum(right: Int): Int {
        var r = right
        var ret = 0
        while (r >= 0) {
            ret += bit[r]
            r = (r and (r + 1)) - 1
        }
        return ret
    }

    fun sum(l: Int, r: Int): Int {
        return sum(r) - sum(l - 1)
    }

    fun add(idx: Int, delta: Int) {
        var i = idx
        while (i < bit.size) {
            bit[i] += delta
            i = i or (i + 1)
        }
    }
}