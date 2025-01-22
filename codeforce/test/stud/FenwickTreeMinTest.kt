package stud

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FenwickTreeMinTest {

    @Test
    fun getMin() {
    }

    @Test
    fun update() {
        val nums = mutableListOf(7, 8, 6, 5, 6, 1, 4, 2)
        val updates =
            listOf(
                intArrayOf(7, 1),
                intArrayOf(6, 2),
                intArrayOf(5, 0),
                intArrayOf(4, 5),
                intArrayOf(3, 4),
                intArrayOf(2, -1)
            )
        val ft = FenwickTreeMin(nums)
        for (u in updates) {
            assert(nums[u[0]] > u[1]) { "Wrong test config, the update must not increase the current value i:${u[0]}, ${nums[u[0]]} > ${u[1]}" }
            nums[u[0]] = u[1]
            ft.update(u[0], u[1])
            for (a in nums.indices) {
                assertEquals(
                    nums.filterIndexed { i, _ -> i <= a }.min(),
                    ft.getMin(a),
                    "Failed for update interval [0,$a] after update $u"
                )
            }
        }
    }
}