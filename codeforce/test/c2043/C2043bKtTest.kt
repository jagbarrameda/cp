//package c2043
//
//import kk
//import org.junit.jupiter.api.Test
//
//import org.junit.jupiter.api.Assertions.*
//import java.math.BigInteger
//
//class C2043bKtTest {
//
//    @Test
//    fun kk() {
//        val testCases = mutableListOf<Pair<Int, Int>>()
//        for (n in 1 .. 7) {
//            for (d in 1..9) {
//                testCases.add(Pair(n,d))
//            }
//        }
//        for ((n, d) in testCases) {
//            val actual = kk(n, d)
//            val expected = naive(n, d)
//            assertArrayEquals(expected.toIntArray(), actual.toIntArray(), "$n, $d")
//        }
//    }
//
//    fun naive(n: Int, d: Int) : List<Int> {
//        val fac = f(n)
//        val sb = StringBuilder()
//        for (i in 1 .. fac) {
//            sb.append(d)
//        }
//        val lo = BigInteger(sb.toString())
//        val ans = mutableListOf<Int>()
//        for (i in 1 .. 9 step 2) {
//            if (lo % BigInteger("$i") == BigInteger("0")) ans.add(i)
//        }
//        return ans
//    }
//
//    fun f(n: Int): Int {
//        if (n == 1) return 1
//        return n * f(n - 1)
//    }
//}