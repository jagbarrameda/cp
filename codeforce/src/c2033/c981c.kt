fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toIntArray()
        var d = 0
        for (i in n / 2 - 1 downTo 0) {
            val j = (n - 1) - i
            if (i == j) continue
            if (i + 1 != j && a[i] != a[j] && (a[i] == a[i + 1] || a[j - 1] == a[j])) {
                val temp = a[i]
                a[i] = a[j]
                a[j] = temp
            }
            d += if (a[i] == a[i + 1]) 1 else 0
            if (i + 1 != j) {
                d += if (a[j - 1] == a[j]) 1 else 0
            }
//            println("$d $i $j $n")
        }
        println(d)
//        println("---")
    }
}