fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var (n, m) = readln().split(' ').map { it.toInt() }
        var max : Long = readln().split(' ').map { it.toLong() }.max()

        while (m-- >0) {
            val (ps, ls, rs) = readln().split(' ')
            val l = ls.toInt()
            val r = rs.toInt()
            if (max in l..r) {
                max += if (ps == "+") 1L else -1L
            }
            print("$max ")
        }
        println()
    }
}