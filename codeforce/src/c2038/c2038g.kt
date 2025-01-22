fun main() {
    var tt = readln().split(" ")[0].toInt()
    while (tt-- > 0) {
        val n = readln().split(" ")[0].toInt()
        val c0 = C2038g.query("0")
        val c00 = C2038g.query("00")
        val c10 = C2038g.query("10")
        if (c0 == c00 + c10) {
            println("0 1 1")
        } else
            println("0 1 0")
        readln()
    }
}

object C2038g {
    fun query(s: String): Int {
        println("1 $s")
        System.out.flush()
        return readln().split(" ")[0].toInt()
    }
}
/*
3
3
0
0
0
1
3
1
0
1
1
3
3
2
0
1

 */