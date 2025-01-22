package stud


class FenwickTree2D(
    n: Int, m: Int
) {
    /* from https://cp-algorithms.com/data_structures/fenwick.html */
    /**
     * binary indexed tree
     */
    private val bit: MutableList<MutableList<Int>> = MutableList(n) { MutableList(m) { 0 } }

    constructor(a: List<List<Int>>) : this(a.size, a[0].size) {
        for (i in a.indices) for (j in a[0].indices) add(i, j, a[i][j])
    }

    fun sum(x: Int, y: Int): Int {
        var ret = 0
        var i = x
        while (i >= 0) {
            var j = y
            while (j >= 0) {
                ret += bit[i][j]
                j = (j and (j + 1)) - 1
            }
            i = (i and (i + 1)) - 1
        }
        return ret
    }

    fun add(x: Int, y: Int, delta: Int) {
        var i = x
        while (i < bit.size) {
            var j = y
            while (j < bit[0].size) {
                bit[i][j] += delta
                j = j or (j + 1)
            }
            i = i or (i + 1)
        }
    }
}