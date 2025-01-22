package stud

import java.util.Collections.binarySearch


class SegTreeLinkedExamples {
    /*
    Solutions to problems in examples in https://cp-algorithms.com/data_structures/segment_tree.html
     */
    companion object {
        fun buildDirectExample(a: List<Int>) {
            // sum
            var st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> x })
            // get multi
            st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x * y }, { x: Int -> x })
            // get gcd
            st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> gcd(x, y) }, { x: Int -> x })
            // count zeros
            st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> if (x == 0) 1 else 0 })
            // max
            st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> if (x >= y) x else y }, { x: Int -> x })
            // min
            st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> if (x <= y) x else y }, { x: Int -> x })
            // max and count
            var st2 = SegTreeLinked<Int, Pair<Int, Int>>(
                0, a.size - 1, a,
                op = { x, y
                    ->
                    if (x.first > y.first) x
                    else if (x.first < y.first) y
                    else Pair(x.first, x.second + y.second)
                },
                e = { x: Int -> Pair(x, 1) })
        }

        private fun gcd(a: Int, b: Int): Int {
            if (a == 0) return b
            if (b == 0) return a
            if (a == b) return a
            if (a > b) return gcd(a - b, b)
            return gcd(a, b - a)
        }

        fun findKthZero(a: List<Int>, k: Int): Int {
            var target = k
            // get a segtree to compute the number of 0s
            var st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x -> if (x == 0) 1 else 0 })
            while (st.lChild != null || st.rChild != null) {
                if (st.lChild!!.v >= target) st = st.lChild!!
                else {
                    target -= st.lChild!!.v
                    st = st.rChild!!
                }
            }
            return st.l
        }

        fun findPrefixWithSum(a: List<Int>, sum: Int): Int {
            var target = sum
            // sum
            var st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> x })
            while (st.v != target) {
                if (st.lChild!!.v >= target) st = st.lChild!!
                else {
                    target -= st.lChild!!.v
                    st = st.rChild!!
                }
            }
            return st.r
        }

        fun findFirstGreaterThan(a: List<Int>, k: Int): Int {
            var st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> kotlin.math.max(x, y) }, { x: Int -> x })
            while (st.lChild != null || st.rChild != null) {
                st = if (st.lChild!!.v > k) st.lChild!! else st.rChild!!
            }
            return st.l
        }

        fun findGreatestSumSubArray(a: List<Int>): Int {
            // T: IntArray(4): t[0] - sum of the entire segment, t[1] - maxPrefix, t[2] - maxSuffix, t[3] - max of any subarray within the segment
            val op: (IntArray, IntArray) -> IntArray = { x, y ->
                intArrayOf(
                    x[0] + y[0], // sum of the entire segment
                    kotlin.math.max(x[1], x[0] + y[1]), // max prefix
                    kotlin.math.max(x[2] + y[0], y[2]), // max suffix
                    kotlin.math.max(
                        kotlin.math.max(x[3], y[3]),
                        x[2] + y[1]
                    ) // max is the max of either child, or the suffix of left + preffix of right
                )
            }
            val e: (Int) -> IntArray = { x ->
                intArrayOf(
                    x,
                    kotlin.math.max(x, 0),
                    kotlin.math.max(x, 0),
                    kotlin.math.max(x, 0)
                )
            }
            var st = SegTreeLinked<Int, IntArray>(0, a.size - 1, a, op, e)
            return st.v[3]
        }

        fun findSmallestGreaterEqualThan(a: List<Int>, l: Int, r: Int, k: Int): Int {
            // S -> Int
            // T -> list<Int>() - sorted
            val st = SegTreeLinked<Int, List<Int>>(0, a.size - 1, a, this::mergeSorted) { x -> listOf(x) }
            return findSmallestGreaterEqualThan(st, l, r, k)
        }

        private fun findSmallestGreaterEqualThan(st: SegTreeLinked<Int, List<Int>>, l: Int, r: Int, k: Int): Int {
            if (st.l == l && st.r == r) {
                var pos = binarySearch(st.v, k)
                if (pos < 0) {
                    pos = -(pos + 1)
                }
                return if (pos >= st.v.size) Int.MAX_VALUE else st.v[pos]
            }
            if (r <= st.lChild!!.r) return findSmallestGreaterEqualThan(st.lChild, l, r, k)
            if (l >= st.rChild!!.l) return findSmallestGreaterEqualThan(st.rChild, l, r, k)
            return kotlin.math.min(
                findSmallestGreaterEqualThan(st.lChild, l, st.lChild.r, k),
                findSmallestGreaterEqualThan(st.rChild, st.rChild.l, r, k))
        }

        fun mergeSorted(a: List<Int>, b: List<Int>): List<Int> {
            var i = 0
            var j = 0
            val ans = mutableListOf<Int>()
            while (i < a.size && j < b.size) {
                if (a[i] <= b[j]) ans.add(a[i++]) else ans.add(b[j++])
            }
            while (i < a.size) ans.add(a[i++])
            while (j < b.size) ans.add(b[j++])
            return ans
        }
    }
}