fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(' ').map { it.toInt() }
        val negCnt = a.count { it == -1 }
        val posCnt = a.count { it == 1 }
        val diff = a.filter { it != -1 && it != 1 }
        val x = if (diff.isNotEmpty()) diff[0] else null
        val sumCnt = negCnt + posCnt + diff.size
        println(sumCnt)

    }
}