/* adapted from ATCODER_SEGTREE_HPP - https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp */
package stud

class SegTree<S>(v: MutableList<S>, val op: (S, S) -> S, val e: () -> S) {

    private var n: Int = v.size
    private var size: Int
    private var log: Int
    private val d: MutableList<S>

    init {
        size = bitCeil(n)
        log = size.countTrailingZeroBits()
        d = MutableList<S>(2 * size) { e() }
        for (i in 0 until n) d[size + i] = v[i];
        for (i in size - 1 downTo 1) {
            update(i);
        }
    }

    private fun bitCeil(i: Int): Int {
        if (i == 0) return 1
        var x = i.takeHighestOneBit()
        if (x < i) x = x shl 1
        return x
    }

    constructor(f: (S, S) -> S, e: () -> S) : this(0, f, e) {
    }

    constructor(n: Int = 0, f: (S, S) -> S, e: () -> S) : this(MutableList<S>(n) { e() }, f, e) {
    }

    fun set(p: Int, x: S) {
        assert(p in 0..<n)
        var pp = p + size
        d[pp] = x;
        for (i in 1..log)
            update(pp shr i)
    }

    fun get(p: Int): S {
        assert(p in 0..<n)
        return d[p + size]
    }

    fun prod(left: Int, right: Int): S {
        var l = left
        var r = right
        assert(l in 0..r && r <= n);
        var sml: S = e()
        var smr: S = e()
        l += size;
        r += size;

        while (l < r) {
            if (l and 1 != 0) sml = op(sml, d[l++])
            if (r and 1 != 0) smr = op(d[--r], smr)
            l = l shr 1
            r = r shr 1
        }
        return op(sml, smr);
    }

    fun allProd(): S {
        return d[1]
    }

    fun maxRight(l: Int): Int {
        return maxRight(l) { _ -> true }
    }

    fun maxRight(left: Int, f: (S) -> Boolean): Int {
        var l = left
        assert(l in 0..n)
        assert(f(e()));
        if (l == n) return n;
        l += size;
        var sm: S = e()
        do {
            while (l % 2 == 0) l = l shr 1
            if (!f(op(sm, d[l]))) {
                while (l < size) {
                    l = (2 * l);
                    if (f(op(sm, d[l]))) {
                        sm = op(sm, d[l]);
                        l++;
                    }
                }
                return l - size;
            }
            sm = op(sm, d[l]);
            l++;
        } while ((l and -l) != l);
        return n;
    }

    fun minLeft(right: Int): Int {
        return minLeft(right) { _ -> true }
    }

    fun minLeft(right: Int, f: (S) -> Boolean): Int {
        var r = right
        assert(r in 0..n)
        assert(f(e()))
        if (r == 0) return 0
        r += size
        var sm: S = e()
        do {
            r--
            while (r > 1 && (r % 2 == 1)) r = r shr 1
            if (!f(op(d[r], sm))) {
                while (r < size) {
                    r = (2 * r + 1)
                    if (f(op(d[r], sm))) {
                        sm = op(d[r], sm)
                        r--
                    }
                }
                return r + 1 - size
            }
            sm = op(d[r], sm);
        } while ((r and -r) != r)
        return 0;
    }

    private fun update(k: Int) {
        d[k] = op(d[2 * k], d[2 * k + 1])
    }
}
