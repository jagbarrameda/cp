fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, d) = readln().split(' ').map { it.toInt() }
        val ans = kk(n, d)
        println(ans.joinToString(" "))

    }
}

fun kk(n:Int, d:Int): List<Int>{
    val f = { x: Int ->
        var n1 = x
        var ret = 1
        while (n1 > 1) {
            ret *= n1
            n1--
        }
        ret
    }
//        println(f(n))
    val ans = mutableListOf(1)
    if (n >= 3 || (d * 10 + d) % 3 == 0) ans.add(3)
    if (d == 5) ans.add(5)
    if (d % 7 == 0 || n >= 3) ans.add(7)
    if ((n <= 5 && (f(n) * d) % 9 == 0) || (n >= 6)) ans.add(9)
    return ans
}