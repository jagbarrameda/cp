package stud

import org.junit.jupiter.api.Assertions.*

class SparseTableTest {

    @org.junit.jupiter.api.Test
    fun qMin() {
        val nums = intArrayOf(-1, 3, 5, 2, -5, 10, 12)
        val st = SparseTable(nums) { x, y -> kotlin.math.min(x, y) }
        for (a in nums.indices) {
            for (b in a + 1 until nums.size) {
                assertEquals(
                    nums.filterIndexed { i, _ -> i in a..b }.min(),
                    st.q(a, b),
                    "Failed for interval [$a,$b]")
            }
        }
    }

    @org.junit.jupiter.api.Test
    fun qMax() {
        val nums = intArrayOf(-1, 3, 5, 2, -5, 10, 12)
        val st = SparseTable(nums) { x, y -> kotlin.math.max(x, y) }
        for (a in nums.indices) {
            for (b in a + 1 until nums.size) {
                assertEquals(
                    nums.filterIndexed { i, _ -> i in a..b }.max(),
                    st.q(a, b),
                    "Failed for interval [$a,$b]")
            }
        }
    }
}