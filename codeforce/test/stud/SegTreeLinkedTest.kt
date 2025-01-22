package stud

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SegTreeLinkedTest {

    @Test
    fun update() {
        // get sum
        var a = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> x })
        a[0] += 5
        st.update(0, a[0])
        a[9] -= 5
        st.update(9, a[9])
        st.update(5, a[5])
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    st.query(i, j),
                    a.filterIndexed { index, _ -> index in i..j }.sum()
                )
            }
        }

        // get multiplication
        a = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x * y }, { x: Int -> x })
        a[0] += 5
        st.update(0, a[0])
        a[9] -= 5
        st.update(9, a[9])
        st.update(5, a[5])
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    st.query(i, j),
                    a.filterIndexed { index, _ -> index in i..j }.reduce { acc, it -> acc * it }
                )
            }
        }

        // get gcd
        a = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> gcd(x, y) }, { x: Int -> x })
        a[0] += 5
        st.update(0, a[0])
        a[9] -= 5
        st.update(9, a[9])
        st.update(5, a[5])
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    st.query(i, j),
                    a.filterIndexed { index, _ -> index in i..j }.reduce { acc, it -> gcd(acc, it) }
                )
            }
        }

        // count zeros
        a = mutableListOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> if (x == 0) 1 else 0 })
        a[0] += 5
        st.update(0, a[0])
        a[5] = 0
        st.update(5, a[5])
        a[9] -= 5
        st.update(9, a[9])
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    a.filterIndexed { index, _ -> index in i..j }.count { it == 0 },
                    st.query(i, j),
                    "failed for i,j= $i, $j"
                )
            }
        }

        // max
        a = mutableListOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> if (x >= y) x else y }, { x: Int -> x })
        a[0] += 5
        st.update(0, a[0])
        a[5] = 0
        st.update(5, a[5])
        a[9] -= 5
        st.update(9, a[9])
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    a.filterIndexed { index, _ -> index in i..j }.max(),
                    st.query(i, j),
                    "failed for i, j = $i, $j"
                )
            }
        }

        // min
        a = mutableListOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> if (x >= y) y else x }, { x: Int -> x })
        a[0] += 5
        st.update(0, a[0])
        a[5] = 0
        st.update(5, a[5])
        a[9] -= 5
        st.update(9, a[9])
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    a.filterIndexed { index, _ -> index in i..j }.min(),
                    st.query(i, j),
                    "failed for i, j = $i, $j"
                )
            }
        }

        // max and count
        a = mutableListOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        a[0] += 5
        st.update(0, a[0])
        a[5] = 0
        st.update(5, a[5])
        a[9] -= 5
        st.update(9, a[9])
        var st2 = SegTreeLinked<Int, Pair<Int, Int>>(
            0, a.size - 1, a,
            op = { x, y
                ->
                if (x.first > y.first) x
                else if (x.first < y.first) y
                else Pair(x.first, x.second + y.second)
            },
            e = { x: Int -> Pair(x, 1) })
        for (i in a.indices) {
            for (j in i until a.size) {
                val max = a.filterIndexed { index, _ -> index in i..j }.max()
                val exp = Pair(
                    max,
                    a.filterIndexed { index, _ -> index in i..j }.count { it == max },
                )
                assertEquals(
                    exp,
                    st2.query(i, j),
                    "failed for i, j = $i, $j"
                )
            }
        }
    }

    @Test
    fun query() {
        // get sum
        var a = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> x })
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    st.query(i, j),
                    a.filterIndexed { index, _ -> index in i..j }.sum()
                )
            }
        }

        // get multi
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x * y }, { x: Int -> x })
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    st.query(i, j),
                    a.filterIndexed { index, _ -> index in i..j }.reduce { acc, it -> acc * it }
                )
            }
        }

        // get gcd
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> gcd(x, y) }, { x: Int -> x })
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    st.query(i, j),
                    a.filterIndexed { index, _ -> index in i..j }.reduce { acc, it -> gcd(acc, it) }
                )
            }
        }

        // count zeros
        a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> x + y }, { x: Int -> if (x == 0) 1 else 0 })
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    a.filterIndexed { index, _ -> index in i..j }.count { it == 0 },
                    st.query(i, j),
                    "failed for i,j= $i, $j"
                )
            }
        }

        // max
        a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> if (x >= y) x else y }, { x: Int -> x })
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    a.filterIndexed { index, _ -> index in i..j }.max(),
                    st.query(i, j),
                    "failed for i, j = $i, $j"
                )
            }
        }

        // min
        a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        st = SegTreeLinked<Int, Int>(0, a.size - 1, a, { x, y -> if (x >= y) y else x }, { x: Int -> x })
        for (i in a.indices) {
            for (j in i until a.size) {
                assertEquals(
                    a.filterIndexed { index, _ -> index in i..j }.min(),
                    st.query(i, j),
                    "failed for i, j = $i, $j"
                )
            }
        }

        // max and count
        a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        var st2 = SegTreeLinked<Int, Pair<Int, Int>>(
            0, a.size - 1, a,
            op = { x, y
                ->
                if (x.first > y.first) x
                else if (x.first < y.first) y
                else Pair(x.first, x.second + y.second)
            },
            e = { x: Int -> Pair(x, 1) })
        for (i in a.indices) {
            for (j in i until a.size) {
                val max = a.filterIndexed { index, _ -> index in i..j }.max()
                val exp = Pair(
                    max,
                    a.filterIndexed { index, _ -> index in i..j }.count { it == max },
                )
                assertEquals(
                    exp,
                    st2.query(i, j),
                    "failed for i, j = $i, $j"
                )
            }
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a
        if (a == b) return a
        if (a > b) return gcd(a - b, b)
        return gcd(a, b - a)
    }
}