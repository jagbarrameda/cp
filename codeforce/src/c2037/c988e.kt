//https://codeforces.com/contest/2037/problem/E

fun main() {
    var tt = readln().toInt()
    while (tt-- > 0) {
        val n = readln().toInt()
        var impossible = true
        var prefLen = 2
        val sb = StringBuilder()
        var prev = 0

        while (prefLen <= n) {
            val r = C988e.query(1, prefLen)
            if (r != 0) {
                if (sb.isEmpty()) {
                    sb.append("1".repeat(prefLen - 1 - r))
                    sb.append("0".repeat(r))
                    sb.append("1")
                    impossible = false
                } else {
                    if (prev == r) {
                        sb.append("0")
                    } else {
                        sb.append("1")
                    }
                }
            }

            prev = r
            prefLen++
        }

        if (impossible) {
            println("! IMPOSSIBLE")
        } else {
            println("! $sb")
        }
    }
}

object C988e {
    fun query(l: Int, r: Int): Int {
        println("? $l $r")
        System.out.flush()
        return readln().toInt()
    }
}