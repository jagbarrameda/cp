fun main() {

    var t = readln().toInt()

    val an = readln().split(" ").map { it.toInt() }
    val ak = readln().split(" ").map { it.toInt() }
    val cache = Array<Long>(an.max().coerceAtLeast(ak.max())) { 0 }
    cache [0] = 1
    for (i in ak.indices) {
        var ans = if (an[i] == ak[i]) 1
        else wrongCoeff(ak[i], cache)
        println(ans)
    }
}

val mod: Long = (1e9 + 7).toLong()

fun wrongCoeff(k: Int, cache: Array<Long>) :Long {
    if (k <= 0) return 1
    if (k == 1) return 2
    if (cache[k] != 0L) return cache[k]
    var ans = wrongCoeff(k / 2, cache)
    ans = if (k % 2 == 0) {
        (ans * ans) % mod
    } else {
        (ans * wrongCoeff(k - k / 2, cache)) % mod
    }
    cache[k] = ans
    return ans
}