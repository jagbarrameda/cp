fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln()
        if (a[0] == '1' && a[n - 1] == '1') {
            println("YES")
            continue
        }
        var zeroGroups = 1 - (a[0] - '0')
        var ones = a[0] - '0'
        for (i in 1 until n) {
            if (a[i] == '1') {
                ones++
                continue
            }
            if (a[i - 1] != '0')
                zeroGroups++
        }
        println(if (ones >= 1 + zeroGroups) "YES" else "NO")
    }
}
