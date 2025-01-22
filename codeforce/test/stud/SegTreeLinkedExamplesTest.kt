package stud

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.exp

class SegTreeLinkedExamplesTest {

    @Test
    fun finKthZero() {
        val a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        val k = 3
        val expected = a.mapIndexed { index, i -> Pair(index, i) }.filter { it.second == 0 }[k - 1].first
        val actual = SegTreeLinkedExamples.findKthZero(a, k)
        assertEquals(expected, actual)
    }

    @Test
    fun findPrefixWithSum() {
        val a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        var expected = 6
        val actual = SegTreeLinkedExamples.findPrefixWithSum(a, a.filterIndexed { index, i -> index <= expected }.sum())
        assertEquals(expected, actual)
    }

    @Test
    fun findFirstGreaterThan() {
        val a = listOf(5, 0, 3, 0, 5, 6, 0, 8, 9, 0)
        val k = 8
        var expected = a.indexOfFirst { it > k }
        val actual = SegTreeLinkedExamples.findFirstGreaterThan(a, k)
        assertEquals(expected, actual)
    }

    @Test
    fun findGreatestSumSubArray() {
        val a = listOf(-5, 0, 3, 0, 5, -6, 0, 8, -9, 0)
        var expected = a[0]
        for (i in a.indices) for (j in i + 1 until a.size)
            expected = kotlin.math.max(expected, a.filterIndexed { index, _ -> index in i..j }.sum())
        val actual = SegTreeLinkedExamples.findGreatestSumSubArray(a)
        assertEquals(expected, actual)
    }

    @Test
    fun findSmallestGreaterEqualThan() {
        val a = listOf(-5, 0, 3, 0, 5, -6, 0, 8, -9, 0)
        val expected = 8
        val actual = SegTreeLinkedExamples.findSmallestGreaterEqualThan(a, 5, 8, 1)
        assertEquals(expected, actual)
    }
}