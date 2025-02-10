package c2057

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class C2057cKtTest {

    @Test
    fun fTest() {
        assertXorSum(0, 2, listOf(2, 1, 0))
        assertXorSum(0, 8, listOf(8, 7, 1))
        assertXorSum(1, 3, listOf(2, 1, 3))
        assertXorSum(6, 22, listOf(7, 16, 11))
        assertXorSum(128, 137, listOf(134, 132, 137))
        assertXorSum(69, 98, listOf(98, 85, 76))
        assertXorSum(115, 127, listOf(123, 121, 118))
        assertXorSum(0, 1073741823, listOf(965321865, 375544086, 12551794))
    }

    fun assertXorSum(l: Int, r: Int, list: List<Int>) {
        val actualList = C2057c.f(l, r)
        val (a, b, c) = actualList
        val actual = xorsum(a, b, c)
        val expected = xorsum(list[0], list[1], list[2])
        assertEquals(expected, actual, "$l $r ${actualList.joinToString (" ")}")
        assert(actualList.min() >= l)
        assert(actualList.max() <= r)
        assertEquals(actualList.distinct().size, 3, "$l $r ${actualList.joinToString (" ")}")
    }

    fun xorsum(a: Int, b: Int, c: Int): Int {
        return (a xor b) + (b xor c) + (c xor a)
    }
}