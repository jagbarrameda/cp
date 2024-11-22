fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val s = readln()
        println(if (s.count {it == 'U'} % 2 == 1) "YES" else "NO")
    }
}