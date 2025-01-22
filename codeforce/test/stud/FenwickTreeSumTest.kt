package stud

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FenwickTreeSumTest {

    @Test
    fun update() {
        val nums = mutableListOf(1, 3, 4, 8, 6, 1, 4, 2)
        val updates =
            listOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(5, -5), intArrayOf(6, -1))
        val ft = FenwickTreeSum(nums)
        for (u in updates) {
            ft.add(u[0], u[1])
            nums[u[0]] += u[1]
            for (a in nums.indices) {
                for (b in a + 1 until nums.size) {
                    assertEquals(
                        nums.filterIndexed { i, _ -> i in a..b }.sum(),
                        ft.sum(a, b),
                        "Failed for update interval [$a,$b] after update $u"
                    )
                }
            }
        }
    }

    @Test
    fun sum() {
        val nums = listOf(1, 3, 4, 8, 6, 1, 4, 2)
        val t = FenwickTreeSum(nums)
        for (a in nums.indices) {
            for (b in a + 1 until nums.size) {
                assertEquals(
                    nums.filterIndexed { i, _ -> i in a..b }.sum(),
                    t.sum(a, b),
                    "Failed for interval [$a,$b]"
                )
            }
        }
    }
}