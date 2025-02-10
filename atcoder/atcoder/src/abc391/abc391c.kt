fun main() {
    var (n, q) = readln().split(' ').map { it.toInt() }
    val a = IntArray(n)
    val cntA = IntArray(n) { 1 }
    for (i in 0 until n) a[i] = i
    var cnt = 0
    while (q-- > 0) {
        val qu = readln()
        if (qu[0] == '1') {
            var (_, i, h) = qu.split(' ').map { it.toInt() }
            i--
            h--
            val curr = a[i]
            if (cntA[curr]==2) cnt--
            if (cntA[h]==1) cnt++
            cntA[curr]--
            cntA[h]++
            a[i]=h
        } else {
            println(cnt)
        }
    }
}