fun main() {
    var tt = readln().toInt()
    while (tt-- > 0) {
        val n = readln().toLong()
        val a = readln().split(" ").map { it.toLong() }

        if (a.max() == a.min()) {
            println(0)
            continue
        }

        var l = 0L // max n_i that does not work
        var r = a.max() + 1 // max n_i that does not work
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (works(mid, a.toLongArray())) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        if (r <= 0L) {
            println(-1)
        } else {
            if (works(r+1, a.toLongArray())) r++
            if (!works(r, a.toLongArray())) r--
            val ops = a.sum() - n * r
            println(ops)
        }
    }
}

fun works(k: Long, a: LongArray): Boolean {
    if (k == 0L) return false
    val n = a.size
    var start = 0
    for (i in a.indices) {
        if (a[i] > a[start]) {
            start = i
        }
    }
    var i = start
    var cnt = 0
    while (cnt < 4 * n || a[i] > k) {
        val next = (i + 1) % n
        if (a[i] > k) {
            val ops = (a[i] + 1 - k) / 2 // ops can make a[i] go to k - 1, this is ok
            if (ops != 0L) {
                a[i] -= 2L * ops // can go 1 below k, this is ok
                a[next] += ops
            }
        }
        i = next
        cnt++
    }
    for (j in a.indices) {
        if (a[j] != k) return false
    }
    return true
}

/*
1
14
62 22 65 24 68 36 93 57 25 22 65 83 78 92
 */