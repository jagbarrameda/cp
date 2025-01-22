fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var ans = true
        var i = 0
        while (i < a.size - 1) {
            if (a[i] == i + 1) {
                i++
                continue
            }
            if (a[i] == i + 2 && a[i + 1] == i + 1) {
                i += 2
                continue
            }
            ans = false
            break
        }
        println(if (ans) "YES" else "NO")
    }
}

/*
4
5
1 2 3 4 5
5
1 3 2 5 4
1
1
5
2 1 4 5 3
 */