fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toInt() }
        if (a.size == 1) {
            println(a[0] + 1)
            continue
        }
        val mx = a.max()
        var ans = mx + a.size / 2
        if (a.size % 2 == 1) {
            for (i in a.indices) {
                if (a[i] == mx && (i % 2 == 0)) {
                    ans++
                    break
                }
            }
        }
        println(ans)
    }
}
/*
6
3
5 4 5
3
4 5 4
10
3 3 3 3 4 1 2 3 4 5
9
17 89 92 42 29 92 14 70 45
100
1 2 2 4 1 1 3 2 3 3 4 1 1 1 3 2 1 2 5 4 2 2 1 4 1 1 1 2 1 4 2 5 2 1 1 4 1 2 1 4 5 3 4 3 1 7 1 3 1 2 1 2 4 7 1 1 1 2 3 1 3 2 1 1 1 2 4 2 1 1 2 3 3 1 1 3 2 4 1 2 1 4 2 1 1 1 1 4 1 1 1 5 2 4 2 2 1 1 5 4
4
10 6 4 7
*/
