fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (a, b, c) = readln().toCharArray()
        if (a.code == c.code) {
            println("$a=$c")
            continue
        }
        if (a.code < c.code) {
            println("$a<$c")
            continue
        }
        if (a.code > c.code) {
            println("$a>$c")
            continue
        }
    }
}
