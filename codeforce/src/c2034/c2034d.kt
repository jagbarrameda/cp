fun main() {

    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val s = readln().split(" ").map { it.toInt() }
        val cnt = IntArray(3)
        for (i in 0 until n) {
            cnt[s[i]]++
        }

        var n0 = 0
        var n1 = cnt[0]
        var n2 = cnt[2]

        val sb = StringBuilder()

        while (n0 < cnt[0] || n1 < cnt[0] + cnt[1] || n2 < n - 1) {
            while (n0 < cnt[0] && s[n0] == 0) n0++
            while (n1 < cnt[0] + cnt[1] && s[n1] == 1) n1++
            while (n2 <= n - 1 && s[n2] == 2) n2++

            if (n0 < cnt[0]) {
                if (s[n0]==1 && s[n1]==0) {
                    sb.appendLine("${n0+1} ${n1+1}")
                    n0++
                    n1++
                    continue
                }
                if (s[n0]==2 && s[n2]==0) {
                    sb.appendLine("${n0+1} ${n2+1}")
                    n0++
                    n2++
                    continue
                }
                if (s[n0]==1) {
                    sb.appendLine("${n0+1} ${n1+1}")
                    n1++
                    continue
                }
                if (s[n0]==2) {
                    sb.appendLine("${n0+1} ${n2+1}")
                    n2++
                    continue
                }
            } else if (n2 <= n - 1) {
                sb.appendLine("${n1+1} ${n2+1}")
                n1++
                n2++
            }
        }
        println(sb.lines().size - 1)
        print(sb)
    }
}