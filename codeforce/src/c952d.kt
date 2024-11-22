fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, m) = readln().split(' ').map { it.toInt() }
        var i = 0
        var iC = 0
        var j = 0
        var done = false
        for (k in 0 until n) {
            val l = readln()
            if (done) continue
            val c = l.count { it == '#' }
            if (c > iC && c % 2 == 1) {
                i = k
                iC = c
                j = l.indexOf("#") + c / 2
            }
            if (iC > c) done = true
        }
        println("${i + 1} ${j + 1}")
    }
}