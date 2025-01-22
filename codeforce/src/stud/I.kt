package stud

import java.io.PrintWriter

object I {
    object sc {
        fun eGcd(a: Int, b: Int): Triple<Int, Int, Int> {
            // extended_euclidean
            // returns g,x,y where a*x+b*y=g, g=gcd(a,b)
            var x = 0
            var y = 0
            var x1 = 0
            var y1 = 1
            var a1 = a
            var b1 = b
            while (b1 != 0) {
                val q = a1 / b1
                Pair(x1, x - q * x1).run {
                    x = first
                    x1 = second
                }
                Pair(y1, y - q * y1).run {
                    y = first
                    y1 = second
                }
                Pair(b1, a1 - q * b1).run {
                    a1 = first
                    b1 = second
                }
            }
            return Triple(a1, x, y)
        }

        fun invMod(a: Int, m: Int): Int {
            // modular inverse
            val (g, x, y) = eGcd(a, m)
            if (g != 1) {
                // "No solution!"
                return -1
            } else {
                return (x % m + m) % m
            }
        }

        //7. bits
        fun Int.has(i: Int): Boolean = (this and (1 shl i) != 0)
        fun Long.has(i: Int): Boolean = (this and (1L shl i) != 0L)
    }

    object io {
        val cin = System.`in`.bufferedReader()
        val cout = PrintWriter(System.out.bufferedWriter())
        val endl = "\n"
        val space = " "
        fun nextLine() = cin.readLine()!!.trim()
        fun nextInt() = nextLine().toInt()
        fun nextLong() = nextLine().toLong()
        fun nextStrings() = nextLine().split(space)
        fun nextInts() = nextStrings().map { it.toInt() }
        fun nextLongs() = nextStrings().map { it.toLong() }
        fun write(a: Int) = cout.write(a.toString() + space)
        fun write(s: String) = cout.write(s)
        fun writeLine(s: String) = cout.write("$s$endl")
        fun flush() = cout.flush()
        fun done() = cout.flush()
    }
}