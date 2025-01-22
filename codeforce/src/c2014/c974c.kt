import java.util.Arrays.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toLong() }.toLongArray()
        if (n <= 2) {
            println("-1")
            continue
        }
        val currAve = 1.0 * a.sum() / a.size
        sort(a)
        val idx = n / 2
        if (currAve / 2 > a[idx]) {
            println(0)
            continue
        }
        val x = (2.0 * a[idx] * n - a.sum()) + 1
//        println("(${2.0 * a[idx]} - ${currAve}) * $n + 1 = $x")
        println(if (x < 0) -1 else x.toLong())
//        println("${Int.MAX_VALUE}")
    }
}
/*
2
3
6 2 2
4
1000000000 1000000000 1000000000 1000000000
*/