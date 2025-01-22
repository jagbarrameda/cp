import java.util.BitSet

//https://codeforces.com/contest/2037/problem/G

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val dp = LongArray(n) // dp[i]: number of path from i until n
    var max = a[0]
    var scndMax = a[0]
    for (i in 1 until n) {
        if (a[i] > max) {
            scndMax = max
            max = a[i]
            continue
        }
        if (a[i] > scndMax)
            scndMax = a[i]
    }
    val primes = C988g.getPrimes(scndMax)
    dp[n-1] = 1L
    var i = n - 2
    while (i >= 0) {
        for (j in i + 1 until n) {
            if (a[i] % a[j] == 0 || a[j] % a[i] == 0) {
                dp[i] = (dp[i] + dp[j]) % C988g.MOD
            } else {
                for (p in primes) {
                    if (p * p > a[i] && p * p > a[j]) break
                    if (a[i] % p == 0 && a[j] % p == 0) {
                        dp[i] = (dp[i] + dp[j]) % C988g.MOD
                        break
                    }
                }
            }
        }
        i--
    }
    println(dp[0])
}

private object C988g {
    const val MOD = 998244353

    fun getPrimes(n: Int): List<Int> {
        val notPrime = BitSet(n+1)
        for (i in 2 until n) {
            if (notPrime[i]) {
                continue
            }
            for (j in i + i .. n step i) {
                notPrime[j] = true
            }
        }
        val ans = mutableListOf<Int>()
        for (i in 2 .. n) {
            if (notPrime[i]) { continue }
            ans.add(i)
        }
        return ans
    }
}