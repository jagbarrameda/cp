fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        val a = IntArray(n)
        for (i in 1 .. n) {
            a[i - 1] = i + i - 1
        }
        println(a.joinToString(" "))
    }
}
