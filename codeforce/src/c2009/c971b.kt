fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        val q = IntArray(n)
        var i = 0
        while (n-- > 0) {
            q[i++] = readln().indexOf("#") + 1
        }
        println(q.reversed().joinToString(" "))
    }
}